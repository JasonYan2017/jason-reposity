package com.JasonYan.fourth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 说明:
 *
 * @author jasonyan
 * @create 2017-11-04 22:05
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.JasonYan.fourth")
public class FourthApplication {
    @Bean
    @LoadBalanced
    public RestTemplate loadBalanced() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(1000);
        requestFactory.setReadTimeout(5000);
        return new RestTemplate(requestFactory);
    }

    public static void main(String[] args) {
        SpringApplication.run(FourthApplication.class, args);
    }
}
