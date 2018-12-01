package com.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ReadExcel {

    public static void main(String[] args) {
        // Provide file location
        File inputFile = new File("C:\\Users\\phild_000\\Desktop\\SampleExcel.xlsx");
        // to read xls, change file extension to xls
        readXlsx(inputFile);
    }


    public static void readXlsx(File inputFile) {
        try {
            // Get the workbook instance for XLSX file
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));
            // to read xls file use HSSFWorkbook

            // Get first sheet from the workbook
            XSSFSheet sheet = wb.getSheetAt(0);
            // to read xls file use HSSFSheet

            Row row;
            Cell cell;

            // Iterate through each row from first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                // For each row, iterate through each column
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    cell = cellIterator.next();

                    switch (cell.getCellTypeEnum()) {
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case STRING:
                            System.out.println(cell.getStringCellValue());
                            break;
                        case BLANK:
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

