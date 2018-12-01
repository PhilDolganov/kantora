package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.MenuTest;
import test.SwitchToWindowTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({MenuTest.class, SwitchToWindowTest.class})
public class BasicSuite {
}
