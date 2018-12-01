package testResources;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class DataResources {
    @DataProvider(name = "Negative_Invalid_Email")
    public static Object[][] getNegativeData1() {
        Object[][] data = new Object[1][5];
        data[0][0] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[0][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[0][3] = data[0][1];
        data[0][4] = "System lets user in with wrong email";
        return data;
    }
    @DataProvider(name = "Negative_Invalid_Password")
    public static Object[][] getNegativeData2() {
        Object[][] data = new Object[1][5];
        data[0][0] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[0][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2] = data[0][0];
        data[0][3] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][4] = "System lets user in with wrong password";;
        return data;
    }
    @DataProvider(name = "Negative_Blank_Email")
    public static Object[][] getNegativeData3() {
        Object[][] data = new Object[1][5];
        data[0][0] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[0][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2] = "";//blank email
        data[0][3] = data[0][1];
        data[0][4] = "System lets user in with blank email";
        return data;
    }
    @DataProvider(name = "Negative_Blank_Password")
    public static Object[][] getNegativeData4() {
        Object[][] data = new Object[1][5];
        data[0][0] = RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@getnada.com";//Email
        data[0][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2] = data[0][0];
        data[0][3] ="";//blank password
        data[0][4] = "System lets user in with wrong password";;
        return data;
    }

    @DataProvider(name = "LoginRU_TestDataProvider")
    public static Object[][] getLogRUData() {
        Faker fake = new Faker();
        Object[][] data = new Object[1][8];
        data[0][0] = fake.internet().emailAddress();//Email
        data[0][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2] = fake.name().firstName();//first name
        data[0][3] = fake.name().firstName();//middle name
        data[0][4] = fake.name().lastName();//last name
        data[0][5] = fake.address().country();//country
        data[0][6] = fake.address().streetAddress();//address
        data[0][7] = fake.phoneNumber().cellPhone();//phone #
        return data;
    }
    @DataProvider(name = "LoginRO_TestDataProvider")
    public static Object[][] getLogROData() {
        Faker fake = new Faker();
        Object[][] data = new Object[1][8];
        data[0][0] = fake.internet().emailAddress();//Email
        data[0][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2] = fake.name().firstName();//first name
        data[0][3] = fake.name().firstName();//middle name
        data[0][4] = fake.name().lastName();//last name
        data[0][5] = fake.address().country();//country
        data[0][6] = fake.address().streetAddress();//address
        data[0][7] = fake.phoneNumber().cellPhone();//phone #
        return data;
    }
    @DataProvider(name = "LoginScout_TestDataProvider")
    public static Object[][] getLogRScoutData() {
        Faker fake = new Faker();
        Object[][] data = new Object[1][8];
        data[0][0] = fake.internet().emailAddress();//Email
        data[0][1] = RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2] = fake.name().firstName();//first name
        data[0][3] = fake.name().firstName();//middle name
        data[0][4] = fake.name().lastName();//last name
        data[0][5] = fake.address().country();//country
        data[0][6] = fake.address().streetAddress();//address
        data[0][7] = fake.phoneNumber().cellPhone();//phone #
        return data;
    }

}
