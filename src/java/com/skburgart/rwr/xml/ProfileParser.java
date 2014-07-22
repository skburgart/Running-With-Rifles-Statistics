package com.skburgart.rwr.xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class ProfileParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File fXmlFile = new File("C:\\Users\\Steven\\Documents\\NetBeansProjects\\RWR Stats\\profiles\\485161409.person");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
    }
}
