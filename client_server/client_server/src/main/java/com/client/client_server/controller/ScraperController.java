package com.client.client_server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/scrape", produces = "application/json")
//fix
//@CrossOrigin()
public class ScraperController{
    
    @GetMapping
    public void scrapeWebsite() {
        System.out.println("hit.....");
    }

    @PostMapping
    public void getScrapedData() {

    }

}
