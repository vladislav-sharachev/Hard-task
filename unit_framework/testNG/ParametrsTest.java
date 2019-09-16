package com.epam.vladislav_sharachev.java.unit_framework.testNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrsTest { //параметризированный тест

    @Parameters("param2")
    @Test(invocationCount = 5) //столько раз запускается тест
    public void test2(@Optional("Не наша переменная") String param) {
        System.out.println("ID current Thread = " + Thread.currentThread().getId());
    }
}