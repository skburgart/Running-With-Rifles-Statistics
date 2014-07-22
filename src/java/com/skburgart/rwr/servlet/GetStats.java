/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skburgart.rwr.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.skburgart.rwr.vo.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
@WebServlet(name = "GetStats", urlPatterns = {"/GetStats"})
public class GetStats extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set json response type
        response.setContentType("application/json;charset=UTF-8");

        Session s = ((SessionFactory) getServletContext().getAttribute("sessionFactory")).openSession();

        List<Player> players = s.createCriteria(Player.class).list();

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
            jsonObject.addProperty("username", p.getUsername());
            jsonObject.addProperty("kills", p.getKills());
            jsonObject.addProperty("deaths", p.getDeaths());
            jsonObject.addProperty("kdratio", String.format("%.2f", p.getKillDeathRatio()));
            jsonObject.addProperty("played", p.getTimePlayedString());
            return jsonObject;
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
