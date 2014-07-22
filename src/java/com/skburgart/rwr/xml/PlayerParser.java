package com.skburgart.rwr.xml;

import com.skburgart.rwr.vo.Player;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    public static Player parseXML(File profileXMLFile, File personXMLFile) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document profileXML = dBuilder.parse(profileXMLFile);
        Document personXML = dBuilder.parse(personXMLFile);

        Player player = new Player();

        Element profile = (Element) profileXML.getElementsByTagName("profile").item(0);
        player.setUsername(profile.getAttribute("username"));
        player.setGame_version(Integer.parseInt(profile.getAttribute("game_version")));
        player.setDigest(profile.getAttribute("digest"));

        Element profile_stats = (Element) profileXML.getElementsByTagName("stats").item(0);
        player.setTime_played(Double.parseDouble(profile_stats.getAttribute("time_played")));
        player.setDeaths(Integer.parseInt(profile_stats.getAttribute("deaths")));
        player.setKills(Integer.parseInt(profile_stats.getAttribute("kills")));
        player.setPlayer_kills(Integer.parseInt(profile_stats.getAttribute("player_kills")));
        player.setTeamkills(Integer.parseInt(profile_stats.getAttribute("teamkills")));
        player.setLongest_kill_streak(Integer.parseInt(profile_stats.getAttribute("longest_kill_streak")));
        player.setTargets_destroyed(Integer.parseInt(profile_stats.getAttribute("targets_destroyed")));
        player.setVehicles_destroyed(Integer.parseInt(profile_stats.getAttribute("vehicles_destroyed")));
        player.setSoldiers_healed(Integer.parseInt(profile_stats.getAttribute("soldiers_healed")));
        player.setTime_played(Integer.parseInt(profile_stats.getAttribute("times_got_healed")));

        Element person = (Element) personXML.getElementsByTagName("person").item(0);
        player.setMax_authority_reached(Double.parseDouble(person.getAttribute("max_authority_reached")));
        player.setAuthority(Double.parseDouble(person.getAttribute("authority")));
        player.setJob_points(Double.parseDouble(person.getAttribute("job_points")));
        player.setFaction(Integer.parseInt(person.getAttribute("faction")));
        player.setName(person.getAttribute("name"));
        player.setVehicles_destroyed(Integer.parseInt(person.getAttribute("version")));
        player.setSoldier_group_id(Integer.parseInt(person.getAttribute("soldier_group_id")));
        player.setBlock(person.getAttribute("block"));
        player.setSquad_size_setting(Integer.parseInt(person.getAttribute("squad_size_setting")));
        player.setSquad_config_index(Integer.parseInt(person.getAttribute("squad_config_index")));

        return player;
    }

    public static ArrayList<Player> parseDirectory(String dir) throws ParserConfigurationException, SAXException, IOException {

        ArrayList<Player> players = new ArrayList<>();

        File[] files = new File(dir).listFiles();

        for (File personFile : files) {
            if (personFile.getName().endsWith("person")) {

                String profileFileName = dir + personFile.getName().replace("person", "profile");
                File profileFile = new File(profileFileName);
                players.add(parseXML(profileFile, personFile));
            }
        }

        return players;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        String profileDir = "C:\\Users\\Steve\\Documents\\NetBeansProjects\\running-with-rifles-stats\\profiles\\";
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();

        ArrayList<Player> players = parseDirectory(profileDir);

        for (Player p : players) {
            session.save(p);
        }

        session.getTransaction().commit();
    }
}
