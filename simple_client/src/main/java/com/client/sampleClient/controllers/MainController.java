package com.client.sampleClient.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.sampleClient.services.ClientService;
import com.client.sampleClient.services.ClassifierService;

@RestController
@RequestMapping(path = "/v1/client")
public class MainController {
  
  private ClientService clientService;
  private ClassifierService classifierService;
  private String fetchedData;

  public MainController(ClientService clientService, ClassifierService classifierService) {
    this.clientService = clientService; 
    this.classifierService = classifierService;
  }

  @GetMapping  
  public String getClient() {
    String value = clientService.getNews(); 
    this.fetchedData = value;
    return value;
  }
  @GetMapping("/filter")  
  public String getClassfier() {
    String value = classifierService.filter(this.fetchedData);
    return value;
  }
}
