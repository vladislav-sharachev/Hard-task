package JUnit.suites;


import JUnit.DivisionTest;
import JUnit.SubtractionTest;
import JUnit.SumTest;
import JUnit.MultiplicationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@Suite.SuiteClasses({DivisionTest.class, MultiplicationTest.class, SubtractionTest.class, SumTest.class})
@RunWith(Suite.class) //аннотация для класса suite.class
public class TestSuits {

}