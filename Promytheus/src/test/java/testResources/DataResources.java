package testResources;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class DataResources {
    @DataProvider(name = "Negative_TestDataProvider")
    public static Object[][] getNegativeData() {
        Object[][] data = new Object[4][5];
        data[0][0] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[0][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[0][3] = data[0][1];
        data[0][4] = "System lets user in with wrong email";
        data[1][0] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[1][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[1][2] = data[1][0];
        data[1][3] = RandomStringUtils.randomAlphanumeric(8);//password
        data[1][4] = "System lets user in with wrong password";
        data[2][0] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[2][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[2][2] = "";
        data[2][3] = data[2][1];
        data[2][4] = "System lets user in with blank email";
        data[3][0] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[3][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[3][2] = data[3][0];
        data[3][3] = "";
        data[3][4] = "System lets user in with blank password";
        return data;
    }
    @DataProvider(name = "LoginRU_TestDataProvider")
    public static Object[][] getLogRUData() {
        Object[][] data = new Object[1][8];
        data[0][0] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[0][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2] = RandomStringUtils.randomAlphabetic(5);//first name
        data[0][3] = RandomStringUtils.randomAlphabetic(5);//middle name
        data[0][4] = RandomStringUtils.randomAlphabetic(5);//last name
        data[0][5] = RandomStringUtils.randomAlphabetic(4,7);//country
        data[0][6] = RandomStringUtils.randomNumeric(4) + " " + RandomStringUtils.randomAlphabetic(5);//address
        data[0][7] = RandomStringUtils.randomNumeric(10);//phone #
        return data;
    }
    @DataProvider(name = "LoginRO_TestDataProvider")
    public static Object[][] getLogROData() {
        Object[][] data = new Object[1][8];
        data[0][0] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[0][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2] = RandomStringUtils.randomAlphabetic(5);//first name
        data[0][3] = RandomStringUtils.randomAlphabetic(5);//middle name
        data[0][4] = RandomStringUtils.randomAlphabetic(5);//last name
        data[0][5] = RandomStringUtils.randomAlphabetic(4,7);//country
        data[0][6] = RandomStringUtils.randomNumeric(4) + " " + RandomStringUtils.randomAlphabetic(5);//address
        data[0][7] = RandomStringUtils.randomNumeric(10);//phone #
        return data;
    }
    @DataProvider(name = "LoginScout_TestDataProvider")
    public static Object[][] getLogRScoutData() {
        Object[][] data = new Object[1][8];
        data[0][0] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[0][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2] = RandomStringUtils.randomAlphabetic(5);//first name
        data[0][3] = RandomStringUtils.randomAlphabetic(5);//middle name
        data[0][4] = RandomStringUtils.randomAlphabetic(5);//last name
        data[0][5] = RandomStringUtils.randomAlphabetic(4,7);//country
        data[0][6] = RandomStringUtils.randomNumeric(4) + " " + RandomStringUtils.randomAlphabetic(5);//address
        data[0][7] = RandomStringUtils.randomNumeric(10);//phone #
        return data;
    }
}

