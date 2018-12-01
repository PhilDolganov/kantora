package com.com.datadriven.test.test.utility;

import com.excel2.utility.Xls_Reader;

import java.util.ArrayList;

public class TestUtil {

    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExcel(){

        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        try {
            reader = new Xls_Reader(System.getProperty("user.dir") + "/src/test/java/com/testdata/HalfEbayTestData.xlsx");
        } catch (Exception e){
            e.printStackTrace();
        }
        for (int rowNum = 2; rowNum <= reader.getRowCount("RegistrationTestData"); rowNum++){

            String firstName = reader.getCellData("RegistrationTestData", "firstname", rowNum);
            String lastName = reader.getCellData("RegistrationTestData", "lastname", rowNum);
            String address1 = reader.getCellData("RegistrationTestData", "address1", rowNum);
            String address2 = reader.getCellData("RegistrationTestData", "address2", rowNum);
            String city = reader.getCellData("RegistrationTestData", "city", rowNum);
            String state = reader.getCellData("RegistrationTestData", "state", rowNum);
            String zipCode = reader.getCellData("RegistrationTestData", "zipcode", rowNum);
            String emailAddress = reader.getCellData("RegistrationTestData", "emailaddress", rowNum);

            myData.add(new Object[]{firstName,lastName,address1,address2,city,state,zipCode,emailAddress});
        }
        return myData;
    }
}
