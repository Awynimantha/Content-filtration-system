package com.webscraper.scraper.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webscraper.scraper.models.WebScraper;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/v1/scraper", produces="application/json")
public class MainController {
    private WebScraper webScraper;

    public MainController(WebScraper webScraper) {
        this.webScraper = webScraper;
    }

    @GetMapping("/scrape")
    public void getScrapedData() throws IOException{
        String url = "";
        webScraper.setUrl(url);
        Document document = webScraper.scrape(); 
        System.out.println(document.body());
    }
    

    
}
