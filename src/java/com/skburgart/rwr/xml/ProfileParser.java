package com.skburgart.rwr.xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class ProfileParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        File profileXMLFile = new File("C:\\Users\\Steven\\Documents\\NetBeansProjects\\RWR Stats\\profiles\\485161409.profile");
        File personXMLFile = new File("C:\\Users\\Steven\\Documents\\NetBeansProjects\\RWR Stats\\profiles\\485161409.person");
        Document profileXML = dBuilder.parse(profileXMLFile);
        Document personXML = dBuilder.parse(personXMLFile);

        Element profile = (Element) profileXML.getElementsByTagName("profile").item(0);
        System.out.println("username -> " + profile.getAttribute("username"));
        System.out.println("game_version -> " + profile.getAttribute("game_version"));
        System.out.println("digest -> " + profile.getAttribute("digest"));

        Element profile_stats = (Element) profileXML.getElementsByTagName("stats").item(0);
        System.out.println("time_played -> " + profile_stats.getAttribute("time_played"));
        System.out.println("kills -> " + profile_stats.getAttribute("deaths"));
        System.out.println("deaths -> " + profile_stats.getAttribute("kills"));
        System.out.println("player_kills -> " + profile_stats.getAttribute("player_kills"));
        System.out.println("teamkills -> " + profile_stats.getAttribute("teamkills"));
        System.out.println("longest_kill_streak -> " + profile_stats.getAttribute("longest_kill_streak"));
        System.out.println("targets_destroyed -> " + profile_stats.getAttribute("targets_destroyed"));
        System.out.println("vehicles_destroyed -> " + profile_stats.getAttribute("vehicles_destroyed"));
        System.out.println("soldiers_healed -> " + profile_stats.getAttribute("soldiers_healed"));
        System.out.println("times_got_healed -> " + profile_stats.getAttribute("times_got_healed"));

        Element person = (Element) personXML.getElementsByTagName("person").item(0);
        System.out.println("max_authority_reached -> " + person.getAttribute("max_authority_reached"));
        System.out.println("authority -> " + person.getAttribute("authority"));
        System.out.println("job_points -> " + person.getAttribute("job_points"));
        System.out.println("faction -> " + person.getAttribute("faction"));
        System.out.println("name -> " + person.getAttribute("name"));
        System.out.println("version -> " + person.getAttribute("version"));
        System.out.println("soldier_group_id -> " + person.getAttribute("soldier_group_id"));
        System.out.println("block -> " + person.getAttribute("block"));
        System.out.println("squad_size_setting -> " + person.getAttribute("squad_size_setting"));
        System.out.println("squad_config_index -> " + person.getAttribute("squad_config_index"));
    }
}
