package com.javafortesters.domainentities;

import com.javafortesters.domainexceptions.InvalidPassword;

public class User implements Comparable {
    private String username;
    private String password;

    public User() throws InvalidPassword {
        this("username", "password");
    }

    public User(String username, String password) throws InvalidPassword {
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

//        if (password.length() < 7){
//            throw new IllegalArgumentException("Password must be > 6 chars");
//        }
//        if (!password.matches(".*[0123456789]+.*")){
//            throw new InvalidPassword("Password must have a digit");
//        }
//        if (!password.matches(".*[A-Z]+.*")){
//            throw new InvalidPassword("Password must have an Uppercase Letter");
//        }
        this.password = password;
    }

    public String getPermission() {
        return "Normal";
    }

    @Override
    public int compareTo(Object oUser2) {
        User user2 = (User)oUser2;

        if (this.getUsername().compareTo(user2.getUsername())==0){
            return 0;
        }

        int user1Comparator = this.getPassword().length() + this.getUsername().length();
        int user2Comparator = user2.getPassword().length() + user2.getUsername().length();

        int val = user1Comparator - user2Comparator;
        if (val==0){
            val = this.getUsername().compareTo(user2.getUsername());
        }
        return val;
    }
}
