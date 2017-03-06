package com.rock.cybski.baseJava.excel;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * JXL创建excel
 * @author rockcybski
 * 
 */
public class JXLExpExcel {
	public static void main(String[] args) {
		// 创建Excel
		File file = new File("d:/jxl_test.xls");
		try {
			file.createNewFile();

			// 创建工作簿
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			// 创建sheet
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			// 创建第一行
			Label label = null;
			String[] title = { "id", "name", "gender" };
			for (int i = 0; i < title.length; i++) {
				label = new Label(i, 0, title[i]);
				sheet.addCell(label);
			}
			// 追加数据
			for (int i = 1; i < 10; i++) {
				label = new Label(0, i, "a" + i);
				sheet.addCell(label);
				label = new Label(1, i, "user" + i);
				sheet.addCell(label);
				label = new Label(2, i, "男");
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
