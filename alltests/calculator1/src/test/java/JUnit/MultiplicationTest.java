package JUnit;

import com.epam.tat.module4.Calculator;
import JUnit.categories.MultAndDiv;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MultiplicationTest extends Assert {

    Calculator calc = new Calculator();

    @Category(MultAndDiv.class)
    @Test
    public void multThree() {
        double result = calc.mult(3, 3);
        assertEquals("Операция умножения 3 на 3 не верная. Актуальный результат = ",
                9, result, 0);

    }

    @Category(MultAndDiv.class)
    @Test
    public void multZero() {
        double result = calc.mult(3, 0);
        assertEquals("Операция умножения 3 на 0 не верная. Актуальный результат = ",
                0, result, 0);

    }

    @Category(MultAndDiv.class)
    @Test
    public void multNegative() {
        double result = calc.mult(3, -1);
        assertEquals("Операция умножения 3 на -1 не верная. Актуальный результат = ",
                -3, result, 0);

    }
}
