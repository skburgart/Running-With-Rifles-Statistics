/**
 * Copyright (c) 2014 Steven Burgart <skburgart@gmail.com>
 * See the file license.txt for copying permission.
 */
package com.skburgart.rwr.update;

import com.skburgart.rwr.vo.Players;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.skburgart.rwr.xml.PlayerParser.parseDirectory;

/**
 * @author Steven Burgart <skburgart@gmail.com>
 */
@Component
public class Update implements Runnable {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Players players;

    @Value("${rwr.profiles.dir}")
    private String profileDirectory;

    @Scheduled(fixedRateString = "${rwr.updateInterval}")
    public void run() {
        players.setPlayers(parseDirectory(profileDirectory));
        log.info(String.format("Updated stats for %d players", players.getPlayers().size()));
    }
}
