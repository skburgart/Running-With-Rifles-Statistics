package com.skburgart.rwr.update;

import com.skburgart.rwr.HibernateUtil;
import com.skburgart.rwr.RWRConfig;
import com.skburgart.rwr.vo.Player;
import static com.skburgart.rwr.xml.PlayerParser.parseDirectory;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.xml.sax.SAXException;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class UpdateRunnable implements Runnable {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    @Override
    public void run() {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ArrayList<Player> players = parseDirectory(RWRConfig.get("profiles.dir"));
            for (Player p : players) {
                session.saveOrUpdate(p);
            }
            session.getTransaction().commit();
            session.close();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
