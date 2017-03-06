package com.rock.cybski.baseJava.excel;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * JXL解析Excel
 * @author rockcybski
 *
 */
public class JXLReadExcel {
	public static void main(String[] args) {
		try {
			//获取workbook
			Workbook workbook = Workbook.getWorkbook(new File("d:/jxl_test.xls"));
			//获取第一个sheet
			Sheet sheet = workbook.getSheet(0);
			//获取数据
			for(int i = 0;i<sheet.getRows();i++){
				for(int j = 0; j<sheet.getColumns();j++){
					Cell cell = sheet.getCell(j, i);
					System.out.print(cell.getContents()+" ");
				}
				System.out.println();
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
