package com.github.roar109.launcher.event.listener;

import com.github.roar109.launcher.event.dto.IncreaseEvent;
import com.google.common.eventbus.Subscribe;
import org.apache.log4j.Logger;

public class IncreaseListener {

    private final Logger LOG = Logger.getLogger(IncreaseListener.class);

    @Subscribe
    public void handle(IncreaseEvent event){
        LOG.info(event);
    }
}
