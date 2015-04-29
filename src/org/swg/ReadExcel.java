package org.swg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * FileUtils.openInputStream(file)����commons-io��
 * �����£��ļ�����������Sheet��Row��Cell
 * @author sun
 *
 */
public class ReadExcel {

	public static void main(String[] args) {
		// Excel�ļ�
		File file = new File("E:\\poi_test.xls");
		try {
			Workbook wb = new HSSFWorkbook(FileUtils.openInputStream(file));
			// Sheet
			Sheet sheet = wb.getSheetAt(0);
			//Sheet���ж�����
			int firstRowNum = sheet.getFirstRowNum();
			int lastRowNum = sheet.getLastRowNum();
			for(int i = firstRowNum;i<lastRowNum;i++){
				Row row = sheet.getRow(i);
				for(int j = row.getFirstCellNum();j<row.getLastCellNum();j++){
					Cell cell = row.getCell(j);
					System.out.print(cell.getStringCellValue()+" ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
