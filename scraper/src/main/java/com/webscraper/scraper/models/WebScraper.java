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
    private Cache cache;

    public WebScraper(Cache cache) {
        this.cache = cache;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String scrape() throws IOException{
        if(this.cache.isCacheExpired()) {
            System.out.println("scraping......");
            this.document = Jsoup.connect(url).timeout(5000).get();
            cache.updateCache(this.document.html());
            return this.document.html();
        }
        System.out.println("Sending cache");
        String content = cache.getCacheData();
        System.out.println(content);
        return content;
    }   
   
}
