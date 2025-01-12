package com.client.client_server.configuration.config_interfaces;

import lombok.Data;

@Data
public abstract class Url {
  private String baseUrl;
  private String version;

  public String getFulUrl() {
    return baseUrl.concat(version);
  }
}

