/**
 * Copyright (c) 2014 Steven Burgart <skburgart@gmail.com>
 * See the file license.txt for copying permission.
 */
package com.skburgart.rwr.controllers;

import com.google.gson.*;
import com.skburgart.rwr.vo.Player;
import com.skburgart.rwr.vo.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Used to get player stats in json format for index.html datatable
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
@RestController
public class Stats {

    @Autowired
    private Players players;

    /**
     * Process HTTP request and return JSON formatted array of player stats
     */
    @RequestMapping("/stats")
    protected String getStats() {
        return playersToJson(players.getPlayers());
    }

    private String playersToJson(List<Player> reports) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapter(Player.class, new PlayerAdapter()).setPrettyPrinting().create();
        return gson.toJson(reports);
    }

    private static class PlayerAdapter implements JsonSerializer<Player> {

        @Override
        public JsonElement serialize(Player p, java.lang.reflect.Type type, JsonSerializationContext jsc) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("username", p.getUsernameAndRank());
            jsonObject.addProperty("xp", p.getExperience());
            jsonObject.addProperty("kills", p.getKills());
            jsonObject.addProperty("deaths", p.getDeaths());
            jsonObject.addProperty("streak", p.getLongestKillStreak());
            jsonObject.addProperty("kdratio", String.format("%.2f", p.getKillDeathRatio()));
            jsonObject.addProperty("kpm", String.format("%.2f", p.getKillsPerMinute()));
            jsonObject.addProperty("played", p.getTimePlayedString());
            jsonObject.addProperty("lastseen", p.getLastSeen());
            jsonObject.addProperty("playedseconds", p.getTimePlayed());
            jsonObject.addProperty("lastseenseconds", p.getLastSeenSeconds());
            return jsonObject;
        }
    }
}
