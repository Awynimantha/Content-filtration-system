package com.webscraper.scraper.models;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebScraper {
    private Document document;
    @Value("${scraper.url}")
    private String url;
    private Cache cache;
    private HTMLScraper htmlScraper;
    
    public WebScraper(HTMLScraper htmlScraper, Cache cache) {
        this.htmlScraper  = htmlScraper; 
        this.cache = cache;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Document scrape() throws IOException{
        if(this.cache.isCacheExpired()) {
            System.out.println("scraping......");
            this.document = Jsoup.connect(url).timeout(5000).get();
            cache.updateCache(this.document.html());
            return this.document;
        }
        System.out.println("Sending cache");
        Document content = cache.getCacheData();
        this.document = content;
        return content;
    }   

    public String getArticleHeadings() throws IOException{
        scrape();
        String result = this.htmlScraper.scrape(this.document).toString();
        return result;
    }   
   
}
