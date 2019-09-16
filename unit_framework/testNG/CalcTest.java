package com.epam.vladislav_sharachev.java.unit_framework.testNG;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalcTest {
    private Calculator calc;
    private double delta = 0.01;

    @BeforeClass //тест зависит от @BeforeClass
    public void init() {
        this.calc = new Calculator();
    }

    @Test
    public void calcDiv() {
        double firstNumber = 10;
        double secondNumber = 1;
        double actualResult = calc.div(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, 10, delta, "Ошибка во время деления 10 на 1");
        System.out.println(actualResult);
    }

    @Test(dependsOnMethods = "calcDiv") // зависимость от метода CalcDiv() - запуск только после него
    public void afterCalcDiv() {
        System.out.println("Деление окончено");
    }

    @AfterClass //выполняется самым последним
    public void afterClass() {
        System.out.println("Тесты окончены");
    }

    @Test
    public void CalcMult() {
        double firstNumber = 10;
        double secondNumber = 5;
        double actualResult = calc.mult(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, 50, delta, "Ошибка во время умножения 10 на 5");
    }

    @Test
    public void CalcSum() {
        double firstNumber = 10;
        double secondNumber = 5;
        double actualResult = calc.sum(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, 15, delta, "Ошибка во время умножения 10 на 5");
    }

    @Test
    public void CalcSub() {
        double firstNumber = 10;
        double secondNumber = 5;
        double actualResult = calc.sub(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, 5, delta, "Ошибка во время умножения 10 на 5");
    }
}
