package com.webscraper.scraper.models;

import java.util.ArrayList;
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
    @Value("${HTMLScraper.cardLink_external}")
    public String cardExternalLink;
    @Value("${HTMLScraper.mainContent}")
    public String mainContent;
    public List<NewsContent> newsContents; 

    public HTMLScraper() {
        newsContents = new ArrayList<NewsContent>();
    }

    public List<NewsContent> scrape(Document document) {
        Elements mainContentEl = document.select(this.mainContent);
        Elements elements = mainContentEl.select(this.newsContainer);
        List<Elements> cards = new ArrayList<>();
        String url = "";
        for(Element element: elements){
            Elements urlElement = element.select(this.cardInternalLink);
            if(urlElement == null) {
                urlElement = element.select(this.cardExternalLink);
            }
            if(urlElement.first() != null) {
                url = urlElement.first().text();
            }
            Elements innerCards = element.select(this.cardDiv);
            for(Element card: innerCards) {
                Elements contents = card.select(this.cardContentDiv);
                for(Element content: contents) {
                    NewsContent newsContent = new NewsContent();
                    newsContent.setStrContent(content.text());
                    newsContent.setUrl(url);
                    newsContents.add(newsContent);
                }
            }
        }
        return newsContents;
    }


    
}
