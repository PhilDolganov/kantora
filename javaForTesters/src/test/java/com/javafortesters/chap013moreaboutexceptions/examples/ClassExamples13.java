package com.javafortesters.chap013moreaboutexceptions.examples;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainexceptions.InvalidPassword;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class ClassExamples13 {
    @Test
    public void canCreateDefaultUserWithoutHandlingException() throws InvalidPassword {
        User aUser = new User();
        assertEquals("username", aUser.getUsername());
        assertEquals("password", aUser.getPassword());
    }

    @Test
    public void haveToCatchIllegalPasswordForParamConstructor() throws InvalidPassword {
        User aUser = new User("me","wrong");
        fail("An exception should have been thrown");
    }

    @Test(expected = InvalidPassword.class)
    public void constructUserWithException() throws InvalidPassword {
        User aUser = new User("username", "p");
    }

    @Test
    public void createDefaultUserWithNoThrowsInvalidPasswordException() throws InvalidPassword {
        User aUser = new User();
        assertEquals("password", aUser.getPassword());
    }

    @Test
    public void createUserWithInvalidPasswordExceptionMessages() throws InvalidPassword {
        User aUser;

        aUser = new User("username", "p");
        fail("An Invalid Password Exception should have been thrown");
    }

    @Test
    public void setPasswordWithInvalidPasswordExceptionMessages() throws InvalidPassword {
        User aUser = new User();

        try {
            aUser.setPassword("tiny");
            fail("An invalid Password Exception should have been thrown");
        } catch (InvalidPassword e){
            assertTrue(e.getMessage().startsWith("Password must be > 6 chars"));
        }
    }
}
