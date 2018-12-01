package com.javafortesters.domainexceptions;

public class InvalidPassword extends Exception {
    public InvalidPassword(String message) {
        super(message);
    }
}
