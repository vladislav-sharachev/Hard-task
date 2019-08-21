package JUnit.suites;



import JUnit.DivisionTest;
import JUnit.MultiplicationTest;
import JUnit.categories.MultAndDiv;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Categories.IncludeCategory(MultAndDiv.class)
@Suite.SuiteClasses({DivisionTest.class, MultiplicationTest.class})
@RunWith(Categories.class)
public class MultTestsSuite {
}
