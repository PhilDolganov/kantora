package com.com.datadriven.test;

import com.excel2.utility.Xls_Reader;

public class ExcelOperations {

    public static void main(String[] args){

        String workingDirectory = System.getProperty("user.dir");
        String resourceFilePath = workingDirectory + "/src/test/java/com/" + "testdata/" + "HalfEbayTestData.xlsx";
        Xls_Reader reader = new Xls_Reader(resourceFilePath);

        if (!reader.isSheetExist("HomePage")){
            reader.addSheet("HomePage");
        }

        int colCount = reader.getColumnCount("RegistrationTestData");
        System.out.println("Total cols present in RegTestData sheet:=====" + colCount);
        System.out.println(reader.getCellRowNum("RegistrationTestData", "firstname", "Tom"));
    }
}
