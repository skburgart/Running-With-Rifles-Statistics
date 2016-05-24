package com.skburgart.rwr.vo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by skburgart on 5/23/16.
 */

@Component
public class Players {

    private ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
