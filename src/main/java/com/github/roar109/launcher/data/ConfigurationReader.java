package com.github.roar109.launcher.data;

import com.github.roar109.launcher.data.dto.Configuration;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;

import java.io.FileReader;

public class ConfigurationReader {

    private final static Logger LOG = Logger.getLogger(ConfigurationReader.class);

    public Configuration readConfiguration(){
        //TODO Validate parameters
        try{
            return new Gson().fromJson(new JsonReader(new FileReader("config.json")), Configuration.class);
        }catch(Exception e){
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }
}
