package com.javafortesters.chap012inheritance.exercises;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainexceptions.InvalidPassword;
import com.javafortesters.domainobject.TestAppEnv;

public class EnvironmentUser extends User {

    public EnvironmentUser() throws InvalidPassword {
    }

    public String getUrl(){
        return TestAppEnv.getUrl();
    }
}
