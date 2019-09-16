package com.epam.vladislav_sharachev.java.unit_framework.JUnit.suites;


import com.epam.vladislav_sharachev.java.unit_framework.JUnit.DivisionTest;
import com.epam.vladislav_sharachev.java.unit_framework.JUnit.MultiplicationTest;
import com.epam.vladislav_sharachev.java.unit_framework.JUnit.categories.MultAndDiv;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Categories.IncludeCategory(MultAndDiv.class)
@Suite.SuiteClasses({DivisionTest.class, MultiplicationTest.class})
@RunWith(Categories.class)
public class MultTestsSuite {
}
