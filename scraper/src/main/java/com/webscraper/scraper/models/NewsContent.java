package com.webscraper.scraper.models;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class NewsContent {
    private String strContent;
    private String url;

    public void createNewsContent(String strContent, String url) {
        this.strContent = strContent;
        this.url = url; 
    }

    
    
}
