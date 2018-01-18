package com.github.roar109.launcher.factory;

import org.quartz.Trigger;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

//TODO create a way to handle this dinamically
public class TicketTriggerFactory {

    private final String TICKER_GROUP_NAME = "tickers";
    private final static TicketTriggerFactory INSTANCE = new TicketTriggerFactory();
    private int count = 0;

    private TicketTriggerFactory() {
    }

    public static TicketTriggerFactory instance() {
        return INSTANCE;
    }

    public Trigger build60SecTrigger() {
        return newTrigger()
                .withIdentity("60SecTicketTrigger-" + (++count), TICKER_GROUP_NAME)
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(60)
                        .repeatForever())
                .build();
    }

    public Trigger build5MinTrigger() {
        return newTrigger()
                .withIdentity("5MinTicketTrigger-" + (++count), TICKER_GROUP_NAME)
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInMinutes(5)
                        .repeatForever())
                .build();
    }

    public Trigger build1MinTrigger() {
        return newTrigger()
                .withIdentity("1MinTicketTrigger-" + (++count), TICKER_GROUP_NAME)
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInMinutes(1)
                        .repeatForever())
                .build();
    }
}
