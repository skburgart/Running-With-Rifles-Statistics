/**
 * Copyright (c) 2014 Steven Burgart <skburgart@gmail.com>
 * See the file license.txt for copying permission.
 */
package com.skburgart.rwr.controllers;

import com.skburgart.rwr.vo.Player;
import com.skburgart.rwr.vo.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Stats {

    @Autowired
    private Players players;

    @RequestMapping("/stats")
    protected ArrayList<Player> getStats() {
        return players.getPlayers();
    }
}