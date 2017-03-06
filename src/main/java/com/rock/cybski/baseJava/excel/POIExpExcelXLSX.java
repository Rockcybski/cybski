package com.rock.cybski.baseJava.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * POI导出Excel (xlsx)
 * @author rockcybski
 *
 */
public class POIExpExcelXLSX {
	public static void main(String[] args) {
		//Create workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		//Create sheet
		XSSFSheet sheet = workbook.createSheet();
		//Create first row
		XSSFRow row = sheet.createRow(0);
		String[] title = { "id", "name", "gender" };
		XSSFCell cell = null;
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//Add more rows
		for(int i=1;i<10;i++){
			XSSFRow nextrow = sheet.createRow(i);
			XSSFCell cell2 = nextrow.createCell(0);
			cell2.setCellValue("a" + i);
			cell2 = nextrow.createCell(1);
			cell2.setCellValue("user" + i);
			cell2 = nextrow.createCell(2);
			cell2.setCellValue("男");
		}
		
		//Create file
		File file = new File("d:/poi_test.xlsx");
		try {
			//save the data
			file.createNewFile();
			FileOutputStream outputStream = FileUtils.openOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
