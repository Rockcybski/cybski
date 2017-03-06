package com.rock.cybski.baseJava.excel;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * POI解析Excel 
 * @author rockcyksi
 *
 */
public class POIReadExcel {
	public static void main(String[] args) {
		File file = new File("d:/poi_test.xls");
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
			HSSFSheet sheet = workbook.getSheetAt(0);
			for(int i=0;i<sheet.getLastRowNum();i++){
				HSSFRow row = sheet.getRow(i);
				for(int j=0;j<row.getLastCellNum();j++){
					HSSFCell cell = row.getCell(j);
					System.out.print(cell.getStringCellValue() + "  ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
