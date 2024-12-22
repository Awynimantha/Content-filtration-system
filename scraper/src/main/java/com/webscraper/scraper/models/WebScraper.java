package com.webscraper.scraper.models;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebScraper {
    private Document document;
    @Value("${scraper.url}")
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Document scrape() throws IOException{
        this.document = Jsoup.connect(url).timeout(5000).get();
        return document;
    }   
   
}
