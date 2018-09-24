package com.xmlreading;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteExcel {

    public static void main(String[] args) {
        // Blank workbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        // Create a blank sheet
        HSSFSheet sheet = workbook.createSheet("Employee Data");

        // This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] { "ID", "NAME", "Company" });
        data.put("2", new Object[] { 1, "Anshul Chauhan", "Kronos Inc." });
        data.put("3", new Object[] { 2, "Shilpi Thakur", "Expedia Inc." });
        data.put("4", new Object[] { 3, "Rohit Maurya", "Amdocs" });
        data.put("5", new Object[] { 4, "Nishi Rajpoot", "AIIMS" });
        data.put("6", new Object[] { 4, "RaviRao Sharman", "Adobe India" });

        // Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            // Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("G:\\SeleniumProjects\\SeleniumUdemy\\src\\test\\java\\com.xmlreading\\SampleEcxcel.xls"));
            workbook.write(out);
            out.close();
            System.out.println("SampleEcxcel.xls written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
