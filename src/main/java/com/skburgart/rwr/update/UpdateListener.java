/**
 * Copyright (c) 2014 ICRL
 * See the file license.txt for copying permission.
 */
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
 * Used to trigger periodic player stat updates
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
@WebListener
public class UpdateListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(UpdateListener.class.getName());

    private static final int UPDATE_INTERVAL_MINS = Integer.parseInt(RWRConfig.get("update.delay"));
    private volatile ScheduledExecutorService executor;

    /**
     * Initiates the scheduled update task
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info(String.format("Loading stat update service - stats will every %d minute(s)", UPDATE_INTERVAL_MINS));
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new UpdateRunnable(), 0, UPDATE_INTERVAL_MINS, TimeUnit.MINUTES);
    }

    /**
     * Cancels the scheduled update task
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("Shutting down stat update service");
        if (executor != null) {
            executor.shutdown();
            this.executor = null;
        }
    }
}
