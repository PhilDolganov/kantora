package com.javafortesters.chap012inheritance.exercises;

import com.javafortesters.domainentities.AdminUser;
import com.javafortesters.domainentities.EmptyUser;
import com.javafortesters.domainentities.ReadOnlyUser;
import com.javafortesters.domainentities.User;
import com.javafortesters.domainexceptions.InvalidPassword;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassExamples12 {

    @Test
    public void emptyUserExampleTest() throws InvalidPassword {
        EmptyUser enu = new EmptyUser();
        assertEquals("username", enu.getUsername());
        assertEquals("password", enu.getPassword());
    }

    @Test
    public void createAnEnvironmentUser() throws InvalidPassword {
        EnvironmentUser enuser = new EnvironmentUser();

        assertEquals("username", enuser.getUsername());
        assertEquals("http://192.123.0.3:67", enuser.getUrl());
    }

    @Test
    public void aUserHasNormalPermissions() throws InvalidPassword {
        User aUser = new User();
        assertEquals("Normal", aUser.getPermission());
    }

    @Test
    public void anAdminUserDefaultConstructor() throws InvalidPassword {
        AdminUser adminUser = new AdminUser();
        assertEquals("adminuser", adminUser.getUsername());
        assertEquals("password", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void anAdminUserHasElevatedPermissions() throws InvalidPassword {
        AdminUser adminUser = new AdminUser("admin","Passw0rd");
        assertEquals("admin", adminUser.getUsername());
        assertEquals("Passw0rd", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void readOnlyUserHasReadOnlyPermissions() throws InvalidPassword {
        ReadOnlyUser readOnlyUser = new ReadOnlyUser();
        assertEquals("username", readOnlyUser.getUsername());
        assertEquals("password", readOnlyUser.getPassword());
        assertEquals("ReadOnly", readOnlyUser.getPermission());

    }
}
