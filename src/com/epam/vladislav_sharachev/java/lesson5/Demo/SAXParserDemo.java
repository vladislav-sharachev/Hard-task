package com.epam.vladislav_sharachev.java.lesson5.Demo;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Alexey_Zinovyev on 15-Aug-16.
 */
public class SAXParserDemo {
    public static void main(String[] args) {
        File input = new File("D:\\EPAM\\EPAM\\Training Catalog\\Java ATM II\\Module 5\\Files\\items.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(input, new BookHandler());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
