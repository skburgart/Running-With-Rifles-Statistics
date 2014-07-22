package com.skburgart.rwr.xml;

import com.skburgart.rwr.RWRConfig;
import com.skburgart.rwr.vo.Player;
import java.io.File;
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
        player.setGameVersion(Integer.parseInt(profile.getAttribute("game_version")));
        player.setDigest(profile.getAttribute("digest"));

        Element profile_stats = (Element) profileXML.getElementsByTagName("stats").item(0);
        player.setTimePlayed(Double.parseDouble(profile_stats.getAttribute("time_played")));
        player.setDeaths(Integer.parseInt(profile_stats.getAttribute("deaths")));
        player.setKills(Integer.parseInt(profile_stats.getAttribute("kills")));
        player.setPlayerKills(Integer.parseInt(profile_stats.getAttribute("player_kills")));
        player.setTeamkills(Integer.parseInt(profile_stats.getAttribute("teamkills")));
        player.setLongestKillStreak(Integer.parseInt(profile_stats.getAttribute("longest_kill_streak")));
        player.setTargetsDestroyed(Integer.parseInt(profile_stats.getAttribute("targets_destroyed")));
        player.setVehiclesDestroyed(Integer.parseInt(profile_stats.getAttribute("vehicles_destroyed")));
        player.setSoldiersHealed(Integer.parseInt(profile_stats.getAttribute("soldiers_healed")));
        player.setTimePlayed(Integer.parseInt(profile_stats.getAttribute("times_got_healed")));

        Element person = (Element) personXML.getElementsByTagName("person").item(0);
        player.setMaxAuthorityReached(Double.parseDouble(person.getAttribute("max_authority_reached")));
        player.setAuthority(Double.parseDouble(person.getAttribute("authority")));
        player.setJobPoints(Double.parseDouble(person.getAttribute("job_points")));
        player.setFaction(Integer.parseInt(person.getAttribute("faction")));
        player.setName(person.getAttribute("name"));
        player.setVehiclesDestroyed(Integer.parseInt(person.getAttribute("version")));
        player.setSoldierGroupId(Integer.parseInt(person.getAttribute("soldier_group_id")));
        player.setBlock(person.getAttribute("block"));
        player.setSquadSizeSetting(Integer.parseInt(person.getAttribute("squad_size_setting")));
        player.setSquadConfigIndex(Integer.parseInt(person.getAttribute("squad_config_index")));

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

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        ArrayList<Player> players = parseDirectory(RWRConfig.get("profiles.dir"));

        for (Player p : players) {
            session.save(p);
        }

        session.getTransaction().commit();
    }
}
