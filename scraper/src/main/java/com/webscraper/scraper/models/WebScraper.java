package com.webscraper.scraper.models;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebScraper {
    private Document document;
    private String url;

    public WebScraper(Document document, String url) throws IOException{
        this.document = Jsoup.connect(url).get();
        this.url = url;
    }
    
   
   
}
