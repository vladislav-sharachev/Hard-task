package JUnit;

import com.epam.tat.module4.Calculator;
import JUnit.categories.SumAndSub;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SumTest extends Assert {

    Calculator calc = new Calculator();

    @Category(SumAndSub.class)
    @Test
    public void sumThree() {
        double result = calc.sum(3, 3);
        assertEquals("Операция сложения 3 плюс 3 не верная. Актуальный результат = ",
                6, result, 0);
    }

    @Category(SumAndSub.class)
    @Test
    public void sumZero() {
        double result = calc.sum(0, 0);
        assertEquals("Операция сложения 0 плюс 0 не верная. Актуальный результат = ",
                0, result, 0);
    }

    @Category(SumAndSub.class)
    @Test
    public void sumMinus() {
        double result = calc.sum(-1, -1);
        assertEquals("Операция сложения -1 плюс -1 не верная. Актуальный результат = ",
                -2, result, 0);
    }
}