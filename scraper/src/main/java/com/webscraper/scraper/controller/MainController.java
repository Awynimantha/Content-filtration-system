package com.webscraper.scraper.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webscraper.scraper.models.Cache;
import com.webscraper.scraper.models.WebScraper;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/v1/scraper", produces="application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class MainController {
    private WebScraper webScraper;

    public MainController(WebScraper webScraper) {
        this.webScraper = webScraper;
    }

    @GetMapping("/scrape")
    public String getScrapedData() throws IOException{
        String url = webScraper.getUrl();
        System.out.println(url);
        webScraper.setUrl(url);
        String document = webScraper.scrape(); 
        return document;
    }

    
}
