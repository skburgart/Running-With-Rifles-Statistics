package com.skburgart.rwr.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
@Entity
@Table(name = "player")
public class Player implements Serializable {

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "game_version")
    private int gameVersion;
    @Column(name = "digest")
    private String digest;
    @Column(name = "time_played")
    private int timePlayed;
    @Column(name = "kills")
    private int kills;
    @Column(name = "deaths")
    private int deaths;
    @Column(name = "player_kills")
    private int playerKills;
    @Column(name = "teamkills")
    private int teamkills;
    @Column(name = "longest_kill_streak")
    private int longestKillStreak;
    @Column(name = "targets_destroyed")
    private int targetsDestroyed;
    @Column(name = "vehicles_destroyed")
    private int vehiclesDestroyed;
    @Column(name = "soldiers_healed")
    private int soldiersHealed;
    @Column(name = "times_got_healed")
    private int timesGotHealed;
    @Column(name = "max_authority_reached")
    private double maxAuthorityReached;
    @Column(name = "authority")
    private double authority;
    @Column(name = "job_points")
    private double jobPoints;
    @Column(name = "faction")
    private int faction;
    @Column(name = "name")
    private String name;
    @Column(name = "version")
    private int version;
    @Column(name = "soldier_group_id")
    private int soldierGroupId;
    @Column(name = "block")
    private String block;
    @Column(name = "squad_size_setting")
    private int squadSizeSetting;
    @Column(name = "squad_config_index")
    private int squadConfigIndex;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(int gameVersion) {
        this.gameVersion = gameVersion;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getPlayerKills() {
        return playerKills;
    }

    public void setPlayerKills(int playerKills) {
        this.playerKills = playerKills;
    }

    public int getTeamkills() {
        return teamkills;
    }

    public void setTeamkills(int teamkills) {
        this.teamkills = teamkills;
    }

    public int getLongestKillStreak() {
        return longestKillStreak;
    }

    public void setLongestKillStreak(int longestKillStreak) {
        this.longestKillStreak = longestKillStreak;
    }

    public int getTargetsDestroyed() {
        return targetsDestroyed;
    }

    public void setTargetsDestroyed(int targetsDestroyed) {
        this.targetsDestroyed = targetsDestroyed;
    }

    public int getVehiclesDestroyed() {
        return vehiclesDestroyed;
    }

    public void setVehiclesDestroyed(int vehiclesDestroyed) {
        this.vehiclesDestroyed = vehiclesDestroyed;
    }

    public int getSoldiersHealed() {
        return soldiersHealed;
    }

    public void setSoldiersHealed(int soldiersHealed) {
        this.soldiersHealed = soldiersHealed;
    }

    public int getTimesGotHealed() {
        return timesGotHealed;
    }

    public void setTimesGotHealed(int timesGotHealed) {
        this.timesGotHealed = timesGotHealed;
    }

    public double getMaxAuthorityReached() {
        return maxAuthorityReached;
    }

    public void setMaxAuthorityReached(double maxAuthorityReached) {
        this.maxAuthorityReached = maxAuthorityReached;
    }

    public double getAuthority() {
        return authority;
    }

    public void setAuthority(double authority) {
        this.authority = authority;
    }

    public double getJobPoints() {
        return jobPoints;
    }

    public void setJobPoints(double jobPoints) {
        this.jobPoints = jobPoints;
    }

    public int getFaction() {
        return faction;
    }

    public void setFaction(int faction) {
        this.faction = faction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getSoldierGroupId() {
        return soldierGroupId;
    }

    public void setSoldierGroupId(int soldierGroupId) {
        this.soldierGroupId = soldierGroupId;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public int getSquadSizeSetting() {
        return squadSizeSetting;
    }

    public void setSquadSizeSetting(int squadSizeSetting) {
        this.squadSizeSetting = squadSizeSetting;
    }

    public int getSquadConfigIndex() {
        return squadConfigIndex;
    }

    public void setSquadConfigIndex(int squadConfigIndex) {
        this.squadConfigIndex = squadConfigIndex;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Double getKillDeathRatio() {

        Double kdratio = (double) getKills() / (double) getDeaths();
        if (Double.isInfinite(kdratio) || Double.isNaN(kdratio)) {
            kdratio = 0.0;
        }

        return kdratio;
    }

    public Double getKillsPerMinute() {

        Double kpm = (double) getKills() / (getTimePlayed() / 60);
        if (Double.isInfinite(kpm) || Double.isNaN(kpm)) {
            kpm = 0.0;
        }

        return kpm;
    }

    public int getExperience() {
        return (int) (getAuthority() * 10000.0);
    }

    public String getTimePlayedString() {

        return elapsedString(getTimePlayed());
    }

    public String getLastSeen() {

        if (getLastSeenSeconds() < 600) {
            return "now";
        }

        return elapsedString(getLastSeenSeconds()) + " ago";
    }

    public Long getLastSeenSeconds() {

        return ((new Date().getTime()) - getLastModified().getTime()) / 1000;
    }

    public String getRank() {
        return Rank.getRank(getExperience()).toString();
    }

    public String getRankIMG() {
        return String.format("<img height=\"25\" src=\"img/rank/%s.png\" />", getRank());
    }

    public static String elapsedString(long seconds) {

        final int SECONDS_PER_DAY = 86400;
        final int SECONDS_PER_HOUR = 3600;
        final int SECONDS_PER_MINUTE = 60;

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
            long minutes = seconds /SECONDS_PER_MINUTE;
            if (minutes > 1) {
                return minutes + " mins";
            } else {
                return minutes + " min";
            }
        }
    }
}
