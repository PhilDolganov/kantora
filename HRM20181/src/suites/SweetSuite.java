package suites;

import basic.PageObjectExampleTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BasicSuite.class, PageObjectExampleTest.class})
public class SweetSuite {
}
