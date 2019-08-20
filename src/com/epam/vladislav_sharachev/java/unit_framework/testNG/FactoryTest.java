package src.com.epam.vladislav_sharachev.java.unit_framework.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class FactoryTest extends TestForFactory {

    @Factory(dataProvider = "dp")
    public FactoryTest (String text, int value) {
        super(text, value);
    }


    @DataProvider(name = "dp")
    public static Object[][] getValues() {
        return new Object[][] {
                new Object[] {"первый текст", 5},
                new Object[] {"второй текст", -2},
                new Object[] {"третий текст", 23*7}
        };
    }
}
