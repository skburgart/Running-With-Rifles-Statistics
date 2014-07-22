package com.skburgart.rwr.vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
@Entity
@Table(name = "player")
public class Player implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "pid")
    private int pid;
    @Column(name = "username")
    private String username;
    @Column(name = "game_version")
    private int game_version;
    @Column(name = "digest")
    private String digest;
    @Column(name = "time_played")
    private double time_played;
    @Column(name = "kills")
    private int kills;
    @Column(name = "deaths")
    private int deaths;
    @Column(name = "player_kills")
    private int player_kills;
    @Column(name = "teamkills")
    private int teamkills;
    @Column(name = "longest_kill_streak")
    private int longest_kill_streak;
    @Column(name = "targets_destroyed")
    private int targets_destroyed;
    @Column(name = "vehicles_destroyed")
    private int vehicles_destroyed;
    @Column(name = "soldiers_healed")
    private int soldiers_healed;
    @Column(name = "times_got_healed")
    private int times_got_healed;
    @Column(name = "max_authority_reached")
    private double max_authority_reached;
    @Column(name = "authority")
    private double authority;
    @Column(name = "job_points")
    private double job_points;
    @Column(name = "faction")
    private int faction;
    @Column(name = "name")
    private String name;
    @Column(name = "version")
    private int version;
    @Column(name = "soldier_group_id")
    private int soldier_group_id;
    @Column(name = "block")
    private String block;
    @Column(name = "squad_size_setting")
    private int squad_size_setting;
    @Column(name = "squad_config_index")
    private int squad_config_index;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGame_version() {
        return game_version;
    }

    public void setGame_version(int game_version) {
        this.game_version = game_version;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public double getTime_played() {
        return time_played;
    }

    public void setTime_played(double time_played) {
        this.time_played = time_played;
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

    public int getPlayer_kills() {
        return player_kills;
    }

    public void setPlayer_kills(int player_kills) {
        this.player_kills = player_kills;
    }

    public int getTeamkills() {
        return teamkills;
    }

    public void setTeamkills(int teamkills) {
        this.teamkills = teamkills;
    }

    public int getLongest_kill_streak() {
        return longest_kill_streak;
    }

    public void setLongest_kill_streak(int longest_kill_streak) {
        this.longest_kill_streak = longest_kill_streak;
    }

    public int getTargets_destroyed() {
        return targets_destroyed;
    }

    public void setTargets_destroyed(int targets_destroyed) {
        this.targets_destroyed = targets_destroyed;
    }

    public int getVehicles_destroyed() {
        return vehicles_destroyed;
    }

    public void setVehicles_destroyed(int vehicles_destroyed) {
        this.vehicles_destroyed = vehicles_destroyed;
    }

    public int getSoldiers_healed() {
        return soldiers_healed;
    }

    public void setSoldiers_healed(int soldiers_healed) {
        this.soldiers_healed = soldiers_healed;
    }

    public int getTimes_got_healed() {
        return times_got_healed;
    }

    public void setTimes_got_healed(int times_got_healed) {
        this.times_got_healed = times_got_healed;
    }

    public double getMax_authority_reached() {
        return max_authority_reached;
    }

    public void setMax_authority_reached(double max_authority_reached) {
        this.max_authority_reached = max_authority_reached;
    }

    public double getAuthority() {
        return authority;
    }

    public void setAuthority(double authority) {
        this.authority = authority;
    }

    public double getJob_points() {
        return job_points;
    }

    public void setJob_points(double job_points) {
        this.job_points = job_points;
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

    public int getSoldier_group_id() {
        return soldier_group_id;
    }

    public void setSoldier_group_id(int soldier_group_id) {
        this.soldier_group_id = soldier_group_id;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public int getSquad_size_setting() {
        return squad_size_setting;
    }

    public void setSquad_size_setting(int squad_size_setting) {
        this.squad_size_setting = squad_size_setting;
    }

    public int getSquad_config_index() {
        return squad_config_index;
    }

    public void setSquad_config_index(int squad_config_index) {
        this.squad_config_index = squad_config_index;
    }
}
