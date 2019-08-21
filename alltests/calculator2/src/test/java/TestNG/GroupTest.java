package TestNG;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTest { //использование зависимости между тестами


    private Calculator calculator = new Calculator();
    private double firstValue = 10;
    private double secondValue = 5;

    @Test(description = "Sub", groups = "firstGroup")
    public void checkSub() {
        Assert.assertEquals(calculator.sub(firstValue, secondValue),
                firstValue - secondValue);
    }

    @Test(description = "Sum", groups = "firstGroup")
    public void checkSum() {
        Assert.assertEquals(calculator.sum(firstValue, secondValue),
                firstValue + secondValue);
    }

    @Test(description = "Div", dependsOnGroups = "firstGroup")
    public void checkDiv() {
        Assert.assertEquals(calculator.div(firstValue, secondValue),
                firstValue / secondValue);
    }

    @Test(description = "Mult", dependsOnGroups = "firstGroup")
    public void checkMult() {
        Assert.assertEquals(calculator.mult(firstValue, secondValue),
                firstValue * secondValue);
    }
}
