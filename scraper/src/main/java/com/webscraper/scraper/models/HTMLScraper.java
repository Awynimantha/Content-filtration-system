package com.webscraper.scraper.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class HTMLScraper {
    @Value("${HTMLScraper.containerDiv}")
    public String newsContainer;
    @Value("${HTMLScraper.cardDiv}")
    public String cardDiv;
    @Value("${HTMLScraper.cardContentDiv}")
    public String cardContentDiv;
    @Value("${HTMLScraper.cardLink_internal}")
    public String cardInternalLink;
    @Value("${HTMLScraper.mainContent}")
    public String mainContent;
    @Value("${scraper.url}")
    public String baseUrl;
    public HashMap<String, String> newsContents; 

    public HTMLScraper() {
        newsContents = new HashMap<>();
    }

    public HashMap<String, String> scrape(Document document) {
        Elements mainContentEl = document.select(this.mainContent);
        Elements elements = mainContentEl.select(this.newsContainer);
        List<Elements> cards = new ArrayList<>();
        String url = "";
        System.out.println(baseUrl);
        for(Element element: elements){
            Elements urlElement = element.select(this.cardInternalLink);
            if(urlElement.first() != null) {
                System.out.println(urlElement.attr("href"));
                url = urlElement.attr("href");
                if(!url.startsWith("https")) {
                    url = baseUrl.concat(url);
                }
                url = "\"".concat(url).concat("\"");
            }
            Elements innerCards = element.select(this.cardDiv);
            for(Element card: innerCards) {
                Elements contents = card.select(this.cardContentDiv);
                for(Element content: contents) {
                    newsContents.put(content.text(), url);
                }
            }
        }
        return newsContents;
    }


    
}
