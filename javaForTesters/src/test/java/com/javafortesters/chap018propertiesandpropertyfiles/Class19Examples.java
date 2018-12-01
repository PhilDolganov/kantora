package com.javafortesters.chap018propertiesandpropertyfiles;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Class19Examples {

    @Test
    public void creatingNewProperties(){
        Properties properties = new Properties();
        assertThat(properties.size(), is(0));

        properties.setProperty("browser", "firefox");
        properties.setProperty("port","80");
        assertThat(properties.getProperty("browser"), is("firefox"));
        assertThat(properties.getProperty("port"), is("80"));
        assertThat(properties.getProperty("missing"),is(nullValue()));
        assertThat(properties.getProperty("missing", "default"),is("default"));

        for (String key : properties.stringPropertyNames()) {
            System.out.println("Key: " + key + " " + "Value: " + properties.getProperty(key));
        }

        properties.list(System.out);

        assertThat(properties.containsKey("browser"), is(true));
    }

    @Test
    public void createAndListAPropertiesObject(){
        Properties properties = new Properties();
        properties.setProperty("name","bob");
        properties.setProperty("gender","male");
        properties.setProperty("password","paSSw0rd");

        assertThat(properties.size(), is(3));
        for (String key : properties.stringPropertyNames()) {
            System.out.println("Key: " + key + " Value: " + properties.getProperty(key));
        }
        properties.list(System.out);
        assertTrue(properties.containsKey("gender"));
        assertEquals("bob", properties.getProperty("name"));
        assertEquals("Admin", properties.getProperty("permission", "Admin"));
    }

    @Test
    public void javaSystemProperties(){

        String workingDirectory = System.getProperty("user.dir");
        String resourceFilePath = workingDirectory + "/src/test/resources/" + "property_files/" + "static_example.properties";

        Properties sys = System.getProperties();
        sys.list(System.out);

    }

    @Test
    public void outputTheSystemPropertiesObject(){
        Properties sys = System.getProperties();
        sys.list(System.out);
    }

    @Test
    public void settingSystemProperties(){
        if (!System.getProperties().containsKey("webdriver.chrome.driver")){
            String currentDir = System.getProperty("user.dir");
            String chromeDriverLocation = currentDir + "/../tools/chromedriver/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
            System.out.println(chromeDriverLocation);
        }
    }

    @Test
    public void workingWithPropertyFiles() throws IOException {
        String tempDirectory = System.getProperty("java.io.tmpdir");
        String tempResourceFilePath = new File(tempDirectory, "tempFileForPropertiesStoreTest.properties").
                getAbsolutePath();

        Properties saved = new Properties();
        saved.setProperty("prop1", "Hello");
        saved.setProperty("prop2", "World");

        FileOutputStream outputFile = new FileOutputStream(tempResourceFilePath);
        saved.store(outputFile, "Hello There World");
        outputFile.close();

        FileReader propertyFileReader = new FileReader(tempResourceFilePath);
        Properties loaded = new Properties();
        try {
            loaded.load(propertyFileReader);
        }finally {
            propertyFileReader.close();
        }

        assertThat(loaded.getProperty("prop1"), is("Hello"));
        assertThat(loaded.getProperty("prop2"), is("World"));

        new File(tempResourceFilePath).delete();
    }

    @Test
    public void storeAndLoadSavedPropertiesFile() throws IOException {

        String tempDirectory = System.getProperty("java.io.tmpdir");
        String tempResourceFilePath = new File(tempDirectory, System.currentTimeMillis()+System.nanoTime()+ ".properties").getAbsolutePath();

        Properties saved = new Properties();

        long nanoTime = System.nanoTime();
        long millis = System.currentTimeMillis();

        saved.setProperty("nanoTime", String.valueOf(nanoTime));
        saved.setProperty("millis", String.valueOf(millis));

        FileOutputStream outputFile = new FileOutputStream(tempResourceFilePath);
        saved.store(outputFile, "Temp Data When File Written");
        outputFile.close();

        FileReader propertyFileReader = new FileReader(tempResourceFilePath);
        Properties loaded = new Properties();
        try {
            loaded.load(propertyFileReader);
        } finally {
            propertyFileReader.close();
        }

        assertThat(loaded.getProperty("nanoTime"), is(String.valueOf(nanoTime)));
        assertThat(loaded.getProperty("millis"), is(String.valueOf(millis)));

        new File(tempResourceFilePath).delete();
    }
}
