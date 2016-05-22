/**
 * Copyright (c) 2014 Steven Burgart <skburgart@gmail.com>
 * See the file license.txt for copying permission.
 */
package com.skburgart.rwr.update;

import com.skburgart.rwr.HibernateUtil;
import com.skburgart.rwr.vo.Player;
import static com.skburgart.rwr.xml.PlayerParser.parseDirectory;
import java.util.ArrayList;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
@Component
public class Update implements Runnable {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${rwr.profile.dir}")
    private String profileDirectory;

    @Scheduled(fixedRate = 5000)
    public void run() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Player> players = parseDirectory(profileDirectory);
        players.forEach(session::saveOrUpdate);
        session.getTransaction().commit();
        session.close();

        log.info(String.format("Updated stats for %d players", players.size()));
    }
}
