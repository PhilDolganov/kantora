
import org.junit.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestHamcrest {
    @Test
    public void test(){
        int sum = 2;
        assertThat("sum test", sum, equalTo(2));
        assertThat(sum, is(2));
        assertThat(sum, is(greaterThan(0)));

        String str = "I hate hamcrest";
        assertThat(str, containsString("I"));
        assertThat(str, containsString("I hate hamcrest"));
    }
}
