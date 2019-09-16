package com.epam.vladislav_sharachev.java.unit_framework.JUnit.suites;

import com.epam.vladislav_sharachev.java.unit_framework.JUnit.SubtractionTest;
import com.epam.vladislav_sharachev.java.unit_framework.JUnit.SumTest;
import com.epam.vladislav_sharachev.java.unit_framework.JUnit.categories.SumAndSub;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Categories.IncludeCategory(SumAndSub.class)
@Suite.SuiteClasses({SumTest.class, SubtractionTest.class})
@RunWith(Categories.class)
public class SumTestsSuite {

}
