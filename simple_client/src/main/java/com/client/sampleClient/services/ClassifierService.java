package com.client.sampleClient.services;

import org.springframework.stereotype.Service;
import com.client.sampleClient.client_endpoint.ScraperClient;
import com.client.sampleClient.client_endpoint.ClassifierClient;
@Service
public class ClassifierService {
  private  ClassifierClient classifierClient;

  public ClassifierService(ClassifierClient client) {
    this.classifierClient = client;
  }

  public String filter(String payload) {
    return this.classifierClient.filterData(payload);
  }
}
