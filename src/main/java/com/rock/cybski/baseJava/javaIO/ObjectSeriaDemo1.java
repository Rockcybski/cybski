package com.rock.cybski.baseJava.javaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSeriaDemo1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		String file = "demo/obj.dat";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		Student stu = new Student("XX", 19, "10001");
		oos.writeObject(stu); //stu must implements interface Serializable 
		oos.flush();
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Student stu1 = (Student)ois.readObject();
		System.out.println(stu1);
		ois.close();
	}
}

class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8818266312802357183L;
	private String name;
	private int age;
	private transient String id; 
	//transient, won't be serialized automatically by jvm
	//If need to serialize, the class need to provide 
	//private void writeObject(...), readObject(...)
	
	public Student(String name, int age, String id){
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException{
		s.defaultWriteObject();//serilize elements can be serilized by jvm, ex. name, age in this Class
		s.writeObject(id);
	}
	
	private void readObject(java.io.ObjectInputStream s) throws java.io.IOException,ClassNotFoundException{
		s.defaultReadObject();
		this.id = (String) s.readObject();
	}
}
