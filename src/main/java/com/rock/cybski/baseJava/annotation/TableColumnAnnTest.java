package com.rock.cybski.baseJava.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class TableColumnAnnTest {
	public static void main(String[] args) {
		User u = new User();
		u.setId(10);
		u.setNickName("Rock");
		u.setEmail("a@roa.com,b@aor.com,c@aoq112.com");
		System.out.println(parseTableColumnAnn(u));
		
	}
	
	/*
	 * Based on user-defined annotation Table, Column, parse an obj to sql
	 * currently only support column value is String and Integer
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static String parseTableColumnAnn(Object obj){
		StringBuilder sb = new StringBuilder();
		//1. get class type
		Class c = obj.getClass();
		//2. if Class is annotated by Table
		if(!c.isAnnotationPresent(Table.class)) return null;
		//3. get table name by get annotation
		Table table = (Table) c.getAnnotation(Table.class);
		String tableName = table.value();
		sb.append("select * from " + tableName + " where 1 = 1");
		
		//4. get all Fields (member variables)
		Field[] fields = c.getDeclaredFields();
		for(Field f:fields){
			//if field is annotated by Column
			if(!f.isAnnotationPresent(Column.class)) continue;
			Column column = f.getAnnotation(Column.class);
			//get column name
			String columnName = column.value();
			//use reflect to get specific value of this field of obj
			String fName = f.getName();
			String methodName = "get"+fName.substring(0, 1).toUpperCase()+fName.substring(1);
			Object columnValue = null;
			try {
				Method getMethod = c.getMethod(methodName);
				columnValue = getMethod.invoke(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//skip null value
			if(columnValue == null || ((columnValue instanceof Integer) && (Integer) columnValue == 0)){
				continue;
			}
			
			//Handle String, Integer
			if(columnValue instanceof String){
				if(((String) columnValue).contains(",")){
					sb.append(" and "+columnName+" in (");
					String[] strs = ((String) columnValue).split(",");
					for(String s:strs){
						sb.append("'"+s+"'"+",");
					}
					sb.deleteCharAt(sb.length()-1).append(")");
				}else{
					sb.append(" and "+columnName+"='"+((String) columnValue)+"'");
				}
			}else if(columnValue instanceof Integer){
				sb.append(" and "+columnName+"="+columnValue);
			}
		}
		
		return sb.toString();
	}
}
