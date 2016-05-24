/**
 * Copyright (c) 2014 Steven Burgart <skburgart@gmail.com>
 * See the file license.txt for copying permission.
 */
package com.skburgart.rwr.vo;

import com.skburgart.rwr.vo.Rank.RankType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * A persistent class that represents a player and associated statistics
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class Player implements Serializable {

    private String username;
    private int gameVersion;
    private String digest;
    private int timePlayed;
    private int kills;
    private int deaths;
    private int playerKills;
    private int teamkills;
    private int longestKillStreak;
    private int targetsDestroyed;
    private int vehiclesDestroyed;
    private int soldiersHealed;
    private int timesGotHealed;
    private double maxAuthorityReached;
    private double authority;
    private double jobPoints;
    private int faction;
    private String name;
    private int version;
    private int soldierGroupId;
    private String block;
    private int squadSizeSetting;
    private int squadConfigIndex;
    private Date lastModified;

    /**
     * get username
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * set username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get game version
     *
     * @return
     */
    public int getGameVersion() {
        return gameVersion;
    }

    /**
     * set game version
     *
     * @param gameVersion
     */
    public void setGameVersion(int gameVersion) {
        this.gameVersion = gameVersion;
    }

    /**
     * get digest
     *
     * @return
     */
    public String getDigest() {
        return digest;
    }

    /**
     * set digest
     *
     * @param digest
     */
    public void setDigest(String digest) {
        this.digest = digest;
    }

    /**
     * get time played
     *
     * @return
     */
    public int getTimePlayed() {
        return timePlayed;
    }

    /**
     * set time played
     *
     * @param timePlayed
     */
    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    /**
     * get kills
     *
     * @return
     */
    public int getKills() {
        return kills;
    }

    /**
     * set kills
     *
     * @param kills
     */
    public void setKills(int kills) {
        this.kills = kills;
    }

    /**
     * get deaths
     *
     * @return
     */
    public int getDeaths() {
        return deaths;
    }

    /**
     * set deaths
     *
     * @param deaths
     */
    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    /**
     * get player kills
     *
     * @return
     */
    public int getPlayerKills() {
        return playerKills;
    }

    /**
     * set player kills
     *
     * @param playerKills
     */
    public void setPlayerKills(int playerKills) {
        this.playerKills = playerKills;
    }

    /**
     * get team kills
     *
     * @return
     */
    public int getTeamkills() {
        return teamkills;
    }

    /**
     * set team kills
     *
     * @param teamkills
     */
    public void setTeamkills(int teamkills) {
        this.teamkills = teamkills;
    }

    /**
     * get longest kill streak
     *
     * @return
     */
    public int getLongestKillStreak() {
        return longestKillStreak;
    }

    /**
     * set longest kill streak
     *
     * @param longestKillStreak
     */
    public void setLongestKillStreak(int longestKillStreak) {
        this.longestKillStreak = longestKillStreak;
    }

    /**
     * get targets destroyed
     *
     * @return
     */
    public int getTargetsDestroyed() {
        return targetsDestroyed;
    }

    /**
     * set targets destroyed
     *
     * @param targetsDestroyed
     */
    public void setTargetsDestroyed(int targetsDestroyed) {
        this.targetsDestroyed = targetsDestroyed;
    }

    /**
     * get vehicles destroyed
     *
     * @return
     */
    public int getVehiclesDestroyed() {
        return vehiclesDestroyed;
    }

    /**
     * set vehicles destroyed
     *
     * @param vehiclesDestroyed
     */
    public void setVehiclesDestroyed(int vehiclesDestroyed) {
        this.vehiclesDestroyed = vehiclesDestroyed;
    }

    /**
     * get soldiers healed
     *
     * @return
     */
    public int getSoldiersHealed() {
        return soldiersHealed;
    }

    /**
     * set soldiers healed
     *
     * @param soldiersHealed
     */
    public void setSoldiersHealed(int soldiersHealed) {
        this.soldiersHealed = soldiersHealed;
    }

    /**
     * get time got healed
     *
     * @return
     */
    public int getTimesGotHealed() {
        return timesGotHealed;
    }

    /**
     * set time got healed
     *
     * @param timesGotHealed
     */
    public void setTimesGotHealed(int timesGotHealed) {
        this.timesGotHealed = timesGotHealed;
    }

    /**
     * get max authority reached
     *
     * @return
     */
    public double getMaxAuthorityReached() {
        return maxAuthorityReached;
    }

    /**
     * set max authority reached
     *
     * @param maxAuthorityReached
     */
    public void setMaxAuthorityReached(double maxAuthorityReached) {
        this.maxAuthorityReached = maxAuthorityReached;
    }

    /**
     * get authority
     *
     * @return
     */
    public double getAuthority() {
        return authority;
    }

    /**
     * set authority
     *
     * @param authority
     */
    public void setAuthority(double authority) {
        this.authority = authority;
    }

    /**
     * get job points
     *
     * @return
     */
    public double getJobPoints() {
        return jobPoints;
    }

    /**
     * set job points
     *
     * @param jobPoints
     */
    public void setJobPoints(double jobPoints) {
        this.jobPoints = jobPoints;
    }

    /**
     * get faction
     *
     * @return
     */
    public int getFaction() {
        return faction;
    }

    /**
     * set faction
     *
     * @param faction
     */
    public void setFaction(int faction) {
        this.faction = faction;
    }

    /**
     * get name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get version
     *
     * @return
     */
    public int getVersion() {
        return version;
    }

    /**
     * set version
     *
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * get soldier group id
     *
     * @return
     */
    public int getSoldierGroupId() {
        return soldierGroupId;
    }

    /**
     * set soldier group id
     *
     * @param soldierGroupId
     */
    public void setSoldierGroupId(int soldierGroupId) {
        this.soldierGroupId = soldierGroupId;
    }

    /**
     * get block
     *
     * @return
     */
    public String getBlock() {
        return block;
    }

    /**
     * set block
     *
     * @param block
     */
    public void setBlock(String block) {
        this.block = block;
    }

    /**
     * get squad size setting
     *
     * @return
     */
    public int getSquadSizeSetting() {
        return squadSizeSetting;
    }

    /**
     * set squad size setting
     *
     * @param squadSizeSetting
     */
    public void setSquadSizeSetting(int squadSizeSetting) {
        this.squadSizeSetting = squadSizeSetting;
    }

    /**
     * get squad config index
     *
     * @return
     */
    public int getSquadConfigIndex() {
        return squadConfigIndex;
    }

    /**
     * set squad config index
     *
     * @param squadConfigIndex
     */
    public void setSquadConfigIndex(int squadConfigIndex) {
        this.squadConfigIndex = squadConfigIndex;
    }

    /**
     * get last modified
     *
     * @return
     */
    public Date getLastModified() {
        return (Date) lastModified.clone();
    }

    /**
     * set last modified
     *
     * @param lastModified
     */
    public void setLastModified(Date lastModified) {
        this.lastModified = (Date) lastModified.clone();
    }

    /**
     * Calculates kill/death ratio
     *
     * @return
     */
    public Double getKillDeathRatio() {

        Double kdratio = (double) getKills() / (double) getDeaths();
        if (Double.isInfinite(kdratio) || Double.isNaN(kdratio)) {
            kdratio = 0.0;
        }

        return kdratio;
    }

    /**
     * Calculates kills per minute
     *
     * @return
     */
    public Double getKillsPerMinute() {

        Double kpm = (double) getKills() / (getTimePlayed() / 60.0);
        if (Double.isInfinite(kpm) || Double.isNaN(kpm)) {
            kpm = 0.0;
        }

        return kpm;
    }

    /**
     * Calculates experience
     *
     * @return
     */
    public int getExperience() {
        return (int) (getAuthority() * 10000.0);
    }

    /**
     * Calculated time played based on seconds elapsed
     *
     * @return
     */
    public String getTimePlayedString() {

        return elapsedString(getTimePlayed());
    }

    /**
     * Determines "last seen" based on last modified time of the xml player
     * files
     *
     * @return
     */
    public String getLastSeen() {

        if (getLastSeenSeconds() < 600) {
            return "now";
        }

        return elapsedString(getLastSeenSeconds()) + " ago";
    }

    /**
     * Determines "last seen" in seconds. Primarily used for sorting the
     * datatable
     *
     * @return
     */
    public Long getLastSeenSeconds() {

        return (new Date().getTime() - getLastModified().getTime()) / 1000;
    }

    /**
     * Returns a combination of user rank image in HTML plus the username
     *
     * @return
     */
    public String getUsernameAndRank() {
        return getRankIMG() + getUsername();
    }

    /**
     * Determines the rank of the player based on xp
     *
     * @return
     */
    public RankType getRank() {
        return Rank.getRank(getExperience());
    }

    /**
     * Constructs HTML img of players rank
     *
     * @return
     */
    public String getRankIMG() {

        RankType rank = getRank();
        return String.format("<img title=\"%s\" height=\"25\" src=\"img/rank/%s.png\" />", rank.getTitle(), rank.toString());
    }

    /**
     * Helper function used to determine time elapsed in days/hours/minutes
     * based on the seconds
     *
     * @param seconds elapsed
     * @return string interpretation of seconds elapsed in days/hours/minutes
     */
    public static String elapsedString(long seconds) {

        final int SECONDS_PER_MINUTE = 60;
        final int SECONDS_PER_HOUR = 60 * SECONDS_PER_MINUTE;
        final int SECONDS_PER_DAY = 24 * SECONDS_PER_HOUR;

        if (seconds >= SECONDS_PER_DAY) { // Days
            long days = seconds / SECONDS_PER_DAY;
            if (days > 1) {
                return days + " days";
            } else {
                return days + " day";
            }
        } else if (seconds >= SECONDS_PER_HOUR) { // Hours
            long hours = seconds / SECONDS_PER_HOUR;
            if (hours > 1) {
                return hours + " hours";
            } else {
                return hours + " hour";
            }
        } else { // Minutes
            long minutes = seconds / SECONDS_PER_MINUTE;
            if (minutes > 1) {
                return minutes + " mins";
            } else {
                return minutes + " min";
            }
        }
    }
}
