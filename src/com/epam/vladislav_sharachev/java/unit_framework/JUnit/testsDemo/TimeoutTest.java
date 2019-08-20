package com.vladislav_sharachev.java.unit_framework.JUnit.testsDemo;

import com.epam.tat.module4.Timeout;
import org.junit.Rule;

public class TimeoutTest {

    @Rule
    public Timeout timeout = new Timeout();

}