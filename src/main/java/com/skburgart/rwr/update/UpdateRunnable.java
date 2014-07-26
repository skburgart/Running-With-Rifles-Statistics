/**
 * Copyright (c) 2014 Steven Burgart
 * See the file license.txt for copying permission.
 */
package com.skburgart.rwr.update;

import com.skburgart.rwr.HibernateUtil;
import com.skburgart.rwr.RWRConfig;
import com.skburgart.rwr.vo.Player;
import static com.skburgart.rwr.xml.PlayerParser.parseDirectory;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class UpdateRunnable implements Runnable {

    private static final Logger log = Logger.getLogger(UpdateRunnable.class.getName());

    @Override
    public void run() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Player> players = parseDirectory(RWRConfig.get("profiles.dir"));
        for (Player p : players) {
            session.saveOrUpdate(p);
        }
        session.getTransaction().commit();
        session.close();
        log.info(String.format("Updated stats for %d players", players.size()));
    }
}
