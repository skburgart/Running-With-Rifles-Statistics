package com.skburgart.rwr.xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class ProfileParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        File fXmlFile = new File("C:\\Users\\Steven\\Documents\\NetBeansProjects\\RWR Stats\\profiles\\485161409.profile");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        Element person = (Element) doc.getElementsByTagName("profile").item(0);
        
        System.out.println("username -> " + person.getAttribute("username"));
        System.out.println("game_version -> " + person.getAttribute("game_version"));
        System.out.println("digest -> " + person.getAttribute("digest"));
    }
}
