/**
 * Copyright (c) 2014 Steven Burgart <skburgart@gmail.com>
 * See the file license.txt for copying permission.
 */
package com.skburgart.rwr.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.skburgart.rwr.HibernateUtil;
import com.skburgart.rwr.vo.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 * Used to get player stats in json format for index.jsp datatable
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
@WebServlet(name = "GetStats", urlPatterns = {"/GetStats"})
public class GetStats extends HttpServlet {

    /**
     * Process HTTP request and return JSON formatted array of player stats
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set json response type
        response.setContentType("application/json;charset=UTF-8");
        Session s = HibernateUtil.getSessionFactory().openSession();

        @SuppressWarnings("unchecked")
        List<Player> players = s.createCriteria(Player.class).list();
        s.close();

        // Write json
        PrintWriter out = response.getWriter();
        out.print(playersToJson(players));
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

    /**
     * Process "get" and "post" the same
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Process "get" and "post" the same
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Short servlet description
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Get all player stats";
    }
}
