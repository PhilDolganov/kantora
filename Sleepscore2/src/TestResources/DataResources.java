package TestResources;

import org.testng.annotations.DataProvider;

public class DataResources {
        @DataProvider(name = "Valid Login and Password")
        public static Object[][] getValidEmailPassword() {
            Object[][] data = new Object[1][4];
            data[0][0] = "krishbharu@yahoo.co.in";// Valid login Email
            data[0][1] = "Anselraj18";// Valid Password
            data[0][2] = data[0][0]; // Expected login text after successful login
            data[0][3] = "System does not log user in with valid login Email and valid password";
            return data;
        }
    @DataProvider(name = "Valid Login and Invalid Password")
    public static Object[][] getValidEmailInvalidPassword() {
        Object[][] data = new Object[1][4];
        data[0][0] = "krishbharu@yahoo.co.in";// Valid login Email
        data[0][1] = "Anselraj1";// Invalid Password
        data[0][2] = "The user name or password is incorrect."; // Expected login text after successful login
        data[0][3] = "System logs user in with valid login Email and invalid password";
        return data;
    }
    @DataProvider(name = "Invalid Login and Valid Password")
    public static Object[][] getInvalidEmailValidPassword() {
        Object[][] data = new Object[1][4];
        data[0][0] = "krishbharu@yahoo.co.i";// Invalid login Email
        data[0][1] = "Anselraj18";// Valid Password
        data[0][2] = "The user name or password is incorrect."; // Expected login text after successful login
        data[0][3] = "System logs user in with invalid login Email and valid password";
        return data;
    }
}
