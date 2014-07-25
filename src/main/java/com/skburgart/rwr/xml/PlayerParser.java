/**
 * Copyright (c) 2014 ICRL
 * See the file license.txt for copying permission.
 */
package com.skburgart.rwr.xml;

import com.skburgart.rwr.vo.Player;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class PlayerParser {

    private static final Logger log = Logger.getLogger(PlayerParser.class.getName());

    public static Player parseXML(File profileXMLFile, File personXMLFile) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document profileXML = dBuilder.parse(profileXMLFile);
        Document personXML = dBuilder.parse(personXMLFile);

        Player player = new Player();

        // Stats from .profile file
        Element profile = (Element) profileXML.getElementsByTagName("profile").item(0);
        player.setUsername(profile.getAttribute("username"));
        player.setGameVersion(Integer.parseInt(profile.getAttribute("game_version")));
        player.setDigest(profile.getAttribute("digest"));

        Element profileStats = (Element) profileXML.getElementsByTagName("stats").item(0);
        player.setTimePlayed((int) Double.parseDouble(profileStats.getAttribute("time_played")));
        player.setDeaths(Integer.parseInt(profileStats.getAttribute("deaths")));
        player.setKills(Integer.parseInt(profileStats.getAttribute("kills")));
        player.setPlayerKills(Integer.parseInt(profileStats.getAttribute("player_kills")));
        player.setTeamkills(Integer.parseInt(profileStats.getAttribute("teamkills")));
        player.setLongestKillStreak(Integer.parseInt(profileStats.getAttribute("longest_kill_streak")));
        player.setTargetsDestroyed(Integer.parseInt(profileStats.getAttribute("targets_destroyed")));
        player.setVehiclesDestroyed(Integer.parseInt(profileStats.getAttribute("vehicles_destroyed")));
        player.setSoldiersHealed(Integer.parseInt(profileStats.getAttribute("soldiers_healed")));
        player.setTimesGotHealed(Integer.parseInt(profileStats.getAttribute("times_got_healed")));

        // Stats from .person file
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

        // Get last modified date
        player.setLastModified(new Date(profileXMLFile.lastModified()));

        return player;
    }

    public static ArrayList<Player> parseDirectory(String dir) throws ParserConfigurationException, SAXException, IOException {

        ArrayList<Player> players = new ArrayList<>();

        File directory = new File(dir);

        log.info(String.format("Searching directory for player profiles '%s'", dir));
        if (!directory.canRead() || !directory.isDirectory()) {
            log.error("Profiles directory not readable - check existence and permission");
            return players;
        }

        File[] files = directory.listFiles();

        for (File personFile : files) {
            if (personFile.getName().endsWith("person")) {

                String profileFileName = dir + personFile.getName().replace("person", "profile");
                File profileFile = new File(profileFileName);
                players.add(parseXML(profileFile, personFile));
            }
        }

        return players;
    }
}
