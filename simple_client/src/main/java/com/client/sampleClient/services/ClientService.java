package com.client.sampleClient.services;

import org.springframework.stereotype.Service;
import com.client.sampleClient.client_endpoint.ScraperClient;
@Service
public class ClientService {
  private final ScraperClient ScraperClient;

  public ClientService(ScraperClient client) {
    this.ScraperClient = client;
  }

  public String getNews() {
    return this.ScraperClient.getScrapeData();
  }
}
