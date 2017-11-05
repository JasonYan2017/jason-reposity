package com.JasonYan.project.second.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 说明:
 *
 * @author jasonyan
 * @create 2017-10-29 21:10
 */


@SpringBootApplication
@ComponentScan("com.JasonYan.project.second")
@EnableEurekaServer //服务端
public class SecondApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecondApplication.class, args);
    }
}
