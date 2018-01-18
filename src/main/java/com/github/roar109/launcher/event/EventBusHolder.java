package com.github.roar109.launcher.event;

import com.github.roar109.launcher.event.listener.DecreaseListener;
import com.github.roar109.launcher.event.listener.IncreaseListener;
import com.google.common.eventbus.EventBus;

public class EventBusHolder {
    private final static EventBusHolder INSTANCE = new EventBusHolder();
    private final EventBus eventBus = new EventBus();

    private EventBusHolder(){ }

    public static EventBusHolder instance(){
        return INSTANCE;
    }

    public void register(boolean eventsEnabled){
        if(eventsEnabled){
            eventBus.register(new IncreaseListener());
            eventBus.register(new DecreaseListener());
        }
    }

    public EventBus getEventBus(){
        return eventBus;
    }
}
