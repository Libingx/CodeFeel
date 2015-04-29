package org.swg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class POIExcelDemo {

	public static void main(String[] args) {
		String[] title = {"id","name","gender"};
		//创建工作薄
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建Sheet
		HSSFSheet sheet = wb.createSheet("Sun");
		//添加第一行
		HSSFRow row = sheet.createRow(0);
		//Cell
		Cell cell = null;
		for(int i = 0;i<title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		
		//追加数据,一行有多个Cell
		for(int i = 1;i<10;i++){
			row = sheet.createRow(i);
			row.createCell(0).setCellValue("a"+i);
			row.createCell(1).setCellValue("user"+i);
			row.createCell(2).setCellValue("男");
		}
		
		//创建一个文件写入Excel
		try {
			File file = new File("E:\\poi_test.xls");
			if(!file.exists()){
				file.createNewFile();
			}
			//文件的输出流
			OutputStream outStream = new FileOutputStream(file);
			//wb写入输出流
			wb.write(outStream);
			outStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
