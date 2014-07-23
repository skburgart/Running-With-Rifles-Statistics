package com.skburgart.rwr.update;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
@WebListener
public class UpdateListener implements ServletContextListener {

    private static final int UPDATE_INTERVAL_MINS = 5;
    private volatile ScheduledExecutorService executor;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new UpdateRunnable(), 0, UPDATE_INTERVAL_MINS, TimeUnit.MINUTES);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (executor != null) {
            executor.shutdown();
            this.executor = null;
        }
    }
}
