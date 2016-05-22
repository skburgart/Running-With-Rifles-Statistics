/**
 * Copyright (c) 2014 Steven Burgart <skburgart@gmail.com>
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * Parses the "profile" and "player" XML files generated by the Running with
 * Rifles dedicated server
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class PlayerParser {

    private static final Logger log = LoggerFactory.getLogger(PlayerParser.class);

    /**
     * Parse a single pair of XML files that represents one player
     *
     * @param profileXMLFile
     * @param personXMLFile
     * @return player object of the parsed stats
     */
    public static Player parseXML(File profileXMLFile, File personXMLFile) {

        Player player = new Player();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document profileXML;
        Document personXML;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            log.warn("Error creating document builder", ex);
            return null;
        }

        try {
            profileXML = dBuilder.parse(profileXMLFile);
        } catch (SAXException | IOException ex) {
            log.warn(String.format("Error parsing profile XML %s", profileXMLFile.getName()), ex);
            return null;
        }

        try {
            personXML = dBuilder.parse(personXMLFile);
        } catch (SAXException | IOException ex) {
            log.warn(String.format("Error parsing person XML %s", personXMLFile.getName()), ex);
            return null;
        }

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

    /**
     * Parse an entire directory of player profiles. Typically this is the
     * "profiles" directory within the Running With Rifles dedicated server
     * directory.
     *
     * @param dir
     * @return ArrayList of players
     */
    public static ArrayList<Player> parseDirectory(String dir) {

        ArrayList<Player> players = new ArrayList<>();

        File directory = new File(dir);

        log.info(String.format("Searching directory for player profiles '%s'", dir));
        if (!directory.canRead() || !directory.isDirectory()) {
            log.error("Profiles directory not readable - check existence and permission");
            return players;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            log.error("Directory listing is null");
            return players;
        }

        for (File personFile : files) {
            if (personFile.getName().endsWith("person")) {

                String profileFileName = dir + personFile.getName().replace("person", "profile");
                File profileFile = new File(profileFileName);
                Player p = parseXML(profileFile, personFile);
                if (p != null) {
                    players.add(parseXML(profileFile, personFile));
                }
            }
        }

        return players;
    }
}
