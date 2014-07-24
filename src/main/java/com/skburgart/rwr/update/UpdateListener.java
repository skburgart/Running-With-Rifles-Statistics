package com.skburgart.rwr.update;

import com.skburgart.rwr.RWRConfig;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.log4j.Logger;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
@WebListener
public class UpdateListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(UpdateListener.class.getName());

    private static final int UPDATE_INTERVAL_MINS = Integer.parseInt(RWRConfig.get("update.delay"));
    private volatile ScheduledExecutorService executor;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info(String.format("Starting stat update server - stats will every %d minute(s)", UPDATE_INTERVAL_MINS));
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new UpdateRunnable(), 0, UPDATE_INTERVAL_MINS, TimeUnit.MINUTES);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("Shutting down stat update service");
        if (executor != null) {
            executor.shutdown();
            this.executor = null;
        }
    }
}
