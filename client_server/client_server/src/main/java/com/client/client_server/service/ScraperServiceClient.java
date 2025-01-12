package com.client.client_server.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "scraper-service")
public interface ScraperServiceClient {
  @GetMapping("/scrape") 
  String getScrapedData();
   
}
  

