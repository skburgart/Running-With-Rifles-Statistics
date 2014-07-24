package com.skburgart.rwr.update;

import com.skburgart.rwr.HibernateUtil;
import com.skburgart.rwr.RWRConfig;
import com.skburgart.rwr.vo.Player;
import static com.skburgart.rwr.xml.PlayerParser.parseDirectory;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.xml.sax.SAXException;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class UpdateRunnable implements Runnable {

    private static final Logger log = Logger.getLogger(UpdateRunnable.class.getName());

    @Override
    public void run() {

        log.info("Updating stats");
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ArrayList<Player> players = parseDirectory(RWRConfig.get("profiles.dir"));
            log.info(String.format("Found %d players to update", players.size()));
            for (Player p : players) {
                session.saveOrUpdate(p);
            }
            session.getTransaction().commit();
            session.close();
            log.info("Stats updated");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            log.error(String.format("Stats update failed: %s", ex.getMessage()));
        }
    }
}
