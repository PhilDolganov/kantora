package com.javafortesters.chap014junitexplored.examples;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainentities.User1;
import com.javafortesters.domainexceptions.InvalidPassword;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ClassExamples14 {

    @Test
    public void thisTestWillNeverFail(){

    }


    @Test(expected = InvalidPassword.class)
    public void expectInvalidPasswordException() throws InvalidPassword {
        User1 user = new User1("username", "<6");
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void invalidPasswordThrown() throws InvalidPassword {
        expected.expect(InvalidPassword.class);
        User1 user = new User1("username", "<6");
    }

    @Test
    public void invalidPasswordThrown2() throws InvalidPassword {
        expected.expect(InvalidPassword.class);
        expected.expectMessage(containsString("Default password incorrect"));
        User1 user = new User1("username", "<6");
    }

    @BeforeClass
    public static void runOncePerClassBeforeAnyTests(){
        System.out.println("@Beforeclass method");
    }

    @Before
    public void runBeforeEveryTestMethod(){
        System.out.println("@Before each method");
    }

    @Ignore("Because it is not finished yet")
    @Test
    public void thisTestIsIgnored(){

    }

    @Test
    public void junitAssertions(){
        assertEquals(6,3 + 3);
        assertEquals("3 + 3 = 6", 6, 3 + 3);

        assertFalse("false is false", false);
        assertFalse(false);

        assertTrue("true is true", true);
        assertTrue(true);

        int[] oneTo10 = {1,2,3,4,5,6,7,8,9,10};
        int[] tenToOne = {10,9,8,7,6,5,4,3,2,1};
        Arrays.sort(tenToOne);
        assertArrayEquals(oneTo10, tenToOne);

        assertNotNull("An empty string is not null", "");
        assertNotNull("");

        assertNotSame("An empty string is not null", null, "");
        assertNotSame(null, "");

        assertNull("Only null is null", null);
        assertNull(null);

        assertSame("Only null is null", null,null);
        assertSame(null,null);
    }

    @Test
    public void hamcrestAssertions(){
        assertThat(3 + 3, is(6));

        //assertThat(3 + 3, is(7));

        assertThat("3 + 3 = 6", 3 + 3, is(6));
        assertThat("3 + 3 = 6", 3 + 3, is(7));

        assertThat("", is(not(nullValue())));
    }

    @Test
    public void assertThatWithHamcrestMatchers(){
        assertThat(3 + 3, is(6));

        //assertThat(3 + 3, is(7));

        assertThat("3 + 3 = 6", 3 + 3,is(6));
        //assertThat("3 + 3 = 6", 3 + 3,is(7));

        assertThat("false is false", false, equalTo(false));
        assertThat(false, is(false));

        assertThat("true is true", true, equalTo(true));
        assertThat(true, is(true));

        int[] oneTo10 = {1,2,3,4,5,6,7,8,9,10};
        int[] tenToOne = {10,9,8,7,6,5,4,3,2,1};
        Arrays.sort(tenToOne);
        assertThat(oneTo10, equalTo(tenToOne));

        assertThat("An empty string is not null", "", is(not(nullValue())));
        assertThat("", is(not(nullValue())));
        assertThat("", is(not(nullValue())));

        assertThat("Only null is null", null,is(nullValue()));
        assertThat(null, nullValue());
    }

    @Test
    public void useTheListedHamcrestMatchers(){
        assertThat(3, is(equalTo(3)));
        assertThat(3, is(not(4)));
        assertThat("This is a string", containsString("is"));
        assertThat("This is a string", endsWith("string"));
        assertThat("This is a string", startsWith("This is"));
    }
}
