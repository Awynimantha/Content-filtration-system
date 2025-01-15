package com.client.sampleClient.client_endpoint;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("mlservice")
@EnableFeignClients
public interface ClassifierClient {
  @GetMapping(path = "/v1/predict") 
  String filterData();
}
