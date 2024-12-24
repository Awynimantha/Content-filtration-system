package com.webscraper.scraper.models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Cache {
    @Value("${cache.duration}")
    private int minDuration;
    private LocalTime createdTime;
    @Value("${cache.location}")
    private String location;

    public Cache() {
        this.createdTime = LocalTime.now();
    }

    public void updateCache(String content) throws IOException {
        FileWriter fileWriter = new FileWriter(location);
        fileWriter.write(content);
        this.createdTime = LocalTime.now();
        fileWriter.close();
    }

    public boolean isCacheExpired() {
        if(LocalTime.now().isAfter(createdTime.plus(minDuration, ChronoUnit.MINUTES))){
            return true;
        }
        return false;
    }

    public String getCacheData() throws IOException {
        FileReader fileReader = new FileReader(location);
        int i = fileReader.read(); 
        StringBuilder stringBuilder = new StringBuilder();
        while(i != -1) {
            stringBuilder.append((char)i);
            i = fileReader.read();
        }
        fileReader.close();
        return stringBuilder.toString();
    }
}
