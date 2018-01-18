package com.github.roar109.launcher.event.listener;

import com.github.roar109.launcher.event.dto.DecreaseEvent;
import com.google.common.eventbus.Subscribe;
import org.apache.log4j.Logger;

public class DecreaseListener {
    private final Logger LOG = Logger.getLogger(DecreaseListener.class);

    @Subscribe
    public void handle(DecreaseEvent event){
        LOG.info(event);
    }
}
