package com.client.client_server.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import com.client.client_server.configuration.config_interfaces.Url;

@ConfigurationProperties(prefix = "url.model")
public class ModelAPIConfig extends Url{
  
}
