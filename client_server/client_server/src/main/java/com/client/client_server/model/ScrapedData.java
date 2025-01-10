package com.client.client_server.model;

import java.util.HashMap;

import lombok.Data;

@Data
public class ScrapedData {
    HashMap<String, String> scrapedData = new HashMap<>();
    
    public void addEntry(String key, String value) {
        scrapedData.put(key, value);
    }
  
}
