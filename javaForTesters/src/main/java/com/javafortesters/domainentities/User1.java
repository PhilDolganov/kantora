package com.javafortesters.domainentities;

import com.javafortesters.domainexceptions.InvalidPassword;

public class User1 {
    private String username;
    private String password;

    public User1() throws InvalidPassword {
        this("username", "password");
    }

    public User1(String username, String password) throws InvalidPassword {
        // only call this because we don't want to throw the exception
        this.username = username;
        try {
            setPassword(password);
        }catch (InvalidPassword e){
            throw new InvalidPassword("Default password incorrect");
        }

    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPassword {

        if (password.length() < 7){
            throw new InvalidPassword("Password must be > 6 chars");
        }

        if (!password.matches(".*[0123456789]+.*")){
            throw new InvalidPassword("Password must have a digit");
        }
        if (!password.matches(".*[A-Z]+.*")){
            throw new InvalidPassword("Password must have an Uppercase Letter");
        }
        this.password = password;
    }

    public String getPermission() {
        return "Normal";
    }
}
