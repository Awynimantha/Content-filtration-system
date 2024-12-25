package com.webscraper.scraper.models;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class HTMLScraper {
    @Value("${HTMLScaper.cardDive}")
    public String cardDiv;
    @Value("${HTMLScaper.cardDive}")
    public String cardContentDiv;
    public List<NewsContent> newsContent; 

    public HTMLScraper() {
        newsContent = new ArrayList<NewsContent>();
    }

    public String scrape(Document document) {
        Elements elements = document.select();
        return elements.html();
    }


    
}
