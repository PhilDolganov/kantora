package com.javafortesters.domainentities;

import com.javafortesters.domainexceptions.InvalidPassword;

public class ReadOnlyUser extends User {

    public ReadOnlyUser() throws InvalidPassword {
    }

    @Override
    public String getPermission(){
        return "ReadOnly";
    }
}
