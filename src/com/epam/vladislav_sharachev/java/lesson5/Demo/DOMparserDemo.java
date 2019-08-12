package com.epam.vladislav_sharachev.java.lesson5.Demo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMparserDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File input = new File("C:\\Vlad Doc\\Java\\5. Files and Pro\\items.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(input);

        System.out.println("Root element " + doc.getDocumentElement().getNodeName());

        NodeList children = doc.getElementsByTagName("book");
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            System.out.println(node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                System.out.println("Book id " + elem.getAttribute("id"));
                System.out.println("author " + elem.getElementsByTagName("author").item(0).getTextContent());
            }
        }
    }
}
