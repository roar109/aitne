package com.github.roar109.launcher;

import com.github.roar109.launcher.data.ConfigurationReader;
import com.github.roar109.launcher.data.dto.Configuration;
import com.github.roar109.launcher.event.EventBusHolder;
import com.github.roar109.launcher.handler.TickerHandler;

import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Scanner;

public class Main {

    private final static Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            LOG.info("The process is taking the 'ask' value of the last trade operation.");

            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();

            Configuration config = new ConfigurationReader().readConfiguration();
            EventBusHolder.instance().register(config.isEventsEnabled());
            new TickerHandler(config.getTickers(), scheduler).executeAndSchedule();

            Scanner scanner = new Scanner( System.in );
            scanner.nextLine();//block until user enters something

            scheduler.shutdown();
        } catch (Exception se) {
            LOG.error(se.getMessage(), se);
        }
    }

}
