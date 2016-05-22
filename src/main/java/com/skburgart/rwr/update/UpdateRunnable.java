/**
 * Copyright (c) 2014 Steven Burgart <skburgart@gmail.com>
 * See the file license.txt for copying permission.
 */
package com.skburgart.rwr.update;

import com.skburgart.rwr.HibernateUtil;
import com.skburgart.rwr.vo.Player;
import static com.skburgart.rwr.xml.PlayerParser.parseDirectory;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
@Component
public class UpdateRunnable implements Runnable {

    private static final Logger log = Logger.getLogger(UpdateRunnable.class.getName());

    @Scheduled(fixedRate = 5000)
    public void run() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Player> players = parseDirectory("/home/skburgart/profiles/");
        for (Player p : players) {
            session.saveOrUpdate(p);
        }
        session.getTransaction().commit();
        session.close();

        System.out.println(String.format("Updated stats for %d players", players.size()));
    }
}
