package com.easybix.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadGenerator {

    private static Logger log = LogManager.getLogger(PayloadGenerator.class.getName());
    public static String generatePayloadString(String filename) {
        log.info("Inside PayloadGenerator function");
        String filePath = System.getProperty("user.dir")+"\\resources\\"+filename;
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e){
            log.error(e);
            return null;
        }
    }
}
