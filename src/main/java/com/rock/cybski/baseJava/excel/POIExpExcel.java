package com.rock.cybski.baseJava.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * POI导出Excel
 * @author rockcybski
 *
 */
public class POIExpExcel {
	public static void main(String[] args) {
		//Create workbook
		HSSFWorkbook workbook = new HSSFWorkbook();
		//Create sheet
		HSSFSheet sheet = workbook.createSheet();
		//Create first row
		HSSFRow row = sheet.createRow(0);
		String[] title = { "id", "name", "gender" };
		HSSFCell cell = null;
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//Add more rows
		for(int i=1;i<10;i++){
			HSSFRow nextrow = sheet.createRow(i);
			HSSFCell cell2 = nextrow.createCell(0);
			cell2.setCellValue("a" + i);
			cell2 = nextrow.createCell(1);
			cell2.setCellValue("user" + i);
			cell2 = nextrow.createCell(2);
			cell2.setCellValue("男");
		}
		//Create file
		File file = new File("d:/poi_test.xls");
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
