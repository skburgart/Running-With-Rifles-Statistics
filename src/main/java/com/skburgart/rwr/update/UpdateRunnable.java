package com.skburgart.rwr.update;

import com.skburgart.rwr.RWRConfig;
import com.skburgart.rwr.vo.Player;
import static com.skburgart.rwr.xml.PlayerParser.parseDirectory;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.xml.sax.SAXException;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class UpdateRunnable implements Runnable {

    @Override
    public void run() {

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            ArrayList<Player> players = parseDirectory(RWRConfig.get("profiles.dir"));
            for (Player p : players) {
                session.saveOrUpdate(p);
            }
            session.getTransaction().commit();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
