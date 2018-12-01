package createproject;

import org.testng.annotations.DataProvider;

public class DataResources {
    @DataProvider(name = "Add Project")
    public static Object[][] getProjectData() {
        Object[][] data = new Object[1][9];//provides all required input data for the test
        data[0][0] = "Project 123";//project name
        data[0][1] = "Bob Jones";//name
        data[0][2] = "bobjones@mail.com";//email
        data[0][3] = "858-544-2342";//ph#
        data[0][4] = "www.bobjones.com";//website
        data[0][5] = "San Jose";//city
        data[0][6] = "95130";//zip
        data[0][7] = "'//*[contains(@class,'create_project')]//TABLE//TR[";//string startStr
        data[0][8] = "]/TD[2]/INPUT'";//string endStr
        return data;
    }
}
