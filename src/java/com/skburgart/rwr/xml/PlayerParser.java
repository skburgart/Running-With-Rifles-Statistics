package com.skburgart.rwr.xml;

import com.skburgart.rwr.vo.Player;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class PlayerParser {

    public static Player parseXML(File profileXMLFile, File personXMLFile) throws SAXException, ParserConfigurationException, IOException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document profileXML = dBuilder.parse(profileXMLFile);
        Document personXML = dBuilder.parse(personXMLFile);

        Player p = new Player();

        Element profile = (Element) profileXML.getElementsByTagName("profile").item(0);
        p.setUsername(profile.getAttribute("username"));
        p.setGame_version(Integer.parseInt(profile.getAttribute("game_version")));
        p.setDigest(profile.getAttribute("digest"));

        Element profile_stats = (Element) profileXML.getElementsByTagName("stats").item(0);
        p.setTime_played(Double.parseDouble(profile_stats.getAttribute("time_played")));
        p.setDeaths(Integer.parseInt(profile_stats.getAttribute("deaths")));
        p.setKills(Integer.parseInt(profile_stats.getAttribute("kills")));
        p.setPlayer_kills(Integer.parseInt(profile_stats.getAttribute("player_kills")));
        p.setTeamkills(Integer.parseInt(profile_stats.getAttribute("teamkills")));
        p.setLongest_kill_streak(Integer.parseInt(profile_stats.getAttribute("longest_kill_streak")));
        p.setTargets_destroyed(Integer.parseInt(profile_stats.getAttribute("targets_destroyed")));
        p.setVehicles_destroyed(Integer.parseInt(profile_stats.getAttribute("vehicles_destroyed")));
        p.setSoldiers_healed(Integer.parseInt(profile_stats.getAttribute("soldiers_healed")));
        p.setTime_played(Integer.parseInt(profile_stats.getAttribute("times_got_healed")));

        Element person = (Element) personXML.getElementsByTagName("person").item(0);
        p.setMax_authority_reached(Double.parseDouble(person.getAttribute("max_authority_reached")));
        p.setAuthority(Double.parseDouble(person.getAttribute("authority")));
        p.setJob_points(Double.parseDouble(person.getAttribute("job_points")));
        p.setFaction(Integer.parseInt(person.getAttribute("faction")));
        p.setName(person.getAttribute("name"));
        p.setVehicles_destroyed(Integer.parseInt(person.getAttribute("version")));
        p.setSoldier_group_id(Integer.parseInt(person.getAttribute("soldier_group_id")));
        p.setBlock(person.getAttribute("block"));
        p.setSquad_size_setting(Integer.parseInt(person.getAttribute("squad_size_setting")));
        p.setSquad_config_index(Integer.parseInt(person.getAttribute("squad_config_index")));

        return p;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        File profileXMLFile = new File("C:\\Users\\Steve\\Documents\\NetBeansProjects\\running-with-rifles-stats\\profiles\\485161409.profile");
        File personXMLFile = new File("C:\\Users\\Steve\\Documents\\NetBeansProjects\\running-with-rifles-stats\\profiles\\485161409.person");

        Player p = parseXML(profileXMLFile, personXMLFile);

        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
    }
}
