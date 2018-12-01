package com.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.internal.Utils.copyFile;

public class CaptureScreenShot {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");

    //public static String captureScreen(WebDriver driver, String screenName) throws IOException {
    public static String captureScreen(WebDriver driver) throws IOException {

        TakesScreenshot screen = (TakesScreenshot) driver;
        //File src = screen.getScreenshotAs(OutputType.FILE);
        String src = screen.getScreenshotAs(OutputType.BASE64);

//        String dest = System.getProperty("user.dir") + "//Test-ScreenShots//" + screenName + ".png";
//
//        File target = new File(dest);
//        copyFile(src, target);
        String dest = "data:image/jpeg;base64, " + src;

        return dest;
    }

    public static String generateFileName(ITestResult result){
        Date date = new Date();
        String fileName = result.getName() + "_" + dateFormat.format(date);
        return fileName;
    }
}
