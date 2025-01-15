package com.webscraper.scraper.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webscraper.scraper.models.Cache;
import com.webscraper.scraper.models.WebScraper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/v1/scraper", produces="application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class MainController {
    private WebScraper webScraper;
    private ObjectMapper objectMapper;
    public MainController(WebScraper webScraper, ObjectMapper objectMapper) {
        this.webScraper = webScraper;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/scrape")
    public String getScrapedData() throws IOException{
        String url = webScraper.getUrl();
        System.out.println(url);
        webScraper.setUrl(url);
        HashMap<String,String> result = webScraper.getArticleHeadings();
        String strJson = objectMapper.writeValueAsString(result);
        return strJson;
    }

    
}
