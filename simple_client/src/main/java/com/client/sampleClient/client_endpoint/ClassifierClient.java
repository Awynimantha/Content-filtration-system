package com.client.sampleClient.client_endpoint;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("mlservice")  // Name of the ML service
@EnableFeignClients
public interface ClassifierClient {
    @PostMapping(path = "/v1/predict", consumes = "application/json")
    String filterData(@RequestBody String input);
}
