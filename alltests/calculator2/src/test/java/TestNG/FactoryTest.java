package TestNG;

import TestNG.ForFactory.ForFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class FactoryTest extends ForFactory {

    @Factory(dataProvider = "dp")
    public FactoryTest (String text, int value) {
        super(text, value);
    }


    @DataProvider(name = "dp")
    public static Object[][] getValues() {
        return new Object[][] {
                new Object[] {"one", 5},
                new Object[] {"two", -2},
                new Object[] {"three", 23*7}
        };
    }
}
