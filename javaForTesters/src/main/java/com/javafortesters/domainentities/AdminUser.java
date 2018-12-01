package com.javafortesters.domainentities;

import com.javafortesters.domainexceptions.InvalidPassword;

public class AdminUser extends User {

    public AdminUser(String username, String password) throws InvalidPassword {
        super(username, password);
    }

    public AdminUser() throws InvalidPassword {
        this("adminuser","password");
    }

    @Override
    public String getPermission() {
        return "Elevated";
    }
}
