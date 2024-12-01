package com.carloscorp.clientservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.carloscorp.clientservice.*")
@Configuration
public class FeignConfig {

}
