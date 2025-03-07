package com.client.sampleClient.client_endpoint;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("scraper")
@EnableFeignClients
public interface ScraperClient {
  @GetMapping(path = "/v1/scraper/scrape") 
  String getScrapeData();
}
