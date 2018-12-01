package suites;

import basic.PageObjectExampleTest;
import homework.HomeworkDay3;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import suites.BasicSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BasicSuite.class, PageObjectExampleTest.class, HomeworkDay3.class})
public class SweetSuite {
}
