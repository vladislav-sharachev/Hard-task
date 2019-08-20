package src.com.epam.vladislav_sharachev.java.unit_framework.testNG;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

public class Runner {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
            TestNG testng = new TestNG();
            for (XmlSuite suite : new Parser("src/com/epam/vladislav_sharachev/java/unit_framework/temp-testng-customsuite.xml").parseToList()) {
                testng.setCommandLineSuite   (suite);
            }
            testng.run();
        }

    }
