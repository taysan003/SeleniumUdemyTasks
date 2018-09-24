package com.xmlreading;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ReadExcel {

	public static void main(String[] args) {

		// Provide File Location
		ReadExcel rdExcel = new ReadExcel();

		rdExcel.readXlsx("G:\\SeleniumProjects\\SeleniumUdemy\\src\\test\\java\\com.xmlreading\\SampleEcxcel.xls");
	}

    public void readXlsx(String filePath) {
        try {
            File inputFile = new File(filePath);

            // Get the workbook instance for XLSX file
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(inputFile));

            // Get first sheet from the workbook
            HSSFSheet sheet = wb.getSheet("Employee Data");

            Row row;
            Cell cell;

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    cell = cellIterator.next();

                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_BOOLEAN :
                            System.out.println(cell.getBooleanCellValue());
                            break;

                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;

                        case Cell.CELL_TYPE_STRING:
                            System.out.println(cell.getStringCellValue());
                            break;

                        case Cell.CELL_TYPE_BLANK:
                            System.out.println("Null");
                            break;

                        default:
                            System.out.println(cell);

                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Exception :" + e.getMessage());
        }
    }

}