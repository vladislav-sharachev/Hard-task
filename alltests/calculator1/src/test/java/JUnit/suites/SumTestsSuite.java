package JUnit.suites;

import JUnit.SubtractionTest;
import JUnit.SumTest;
import JUnit.categories.SumAndSub;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Categories.IncludeCategory(SumAndSub.class)
@Suite.SuiteClasses({SumTest.class, SubtractionTest.class})
@RunWith(Categories.class)
public class SumTestsSuite {

}
