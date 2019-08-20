package com.vladislav_sharachev.java.unit_framework.JUnit.suites;


import com.vladislav_sharachev.java.unit_framework.JUnit.DivisionTest;
import com.vladislav_sharachev.java.unit_framework.JUnit.SubtractionTest;
import com.vladislav_sharachev.java.unit_framework.JUnit.SumTest;
import com.vladislav_sharachev.java.unit_framework.JUnit.MultiplicationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// данный

@Suite.SuiteClasses({DivisionTest.class, MultiplicationTest.class, SubtractionTest.class, SumTest.class})
@RunWith(Suite.class) //аннотация для класса suite.class
public class TestSuits {

}