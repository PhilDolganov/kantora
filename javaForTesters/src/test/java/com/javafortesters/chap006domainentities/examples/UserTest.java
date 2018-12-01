package com.javafortesters.chap006domainentities.examples;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainexceptions.InvalidPassword;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void canConstructANewUser() throws InvalidPassword {
        User user = new User();
    }

    @Test
    public void userHasDefaultUsernameAndPassword() throws InvalidPassword {
        User user = new User();
        assertEquals("default username expected", "username", user.getUsername());
        assertEquals("default password expected", "password", user.getPassword());

    }

    @Test
    public void canConstructWithUsernameAndPassword() throws InvalidPassword {
        User user = new User("admin", "pA55w0rD");
        assertEquals("given username expected", "admin", user.getUsername());
        assertEquals("given password expected", "pA55w0rD", user.getPassword());
    }

    @Test
    public void canSetPasswordAfterConstructed() throws InvalidPassword {
        User user = new User();
        user.setPassword("PaZZwor6");
        assertEquals("setter password expected","PaZZwor6", user.getPassword());
    }
}
