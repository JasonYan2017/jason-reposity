package com.JasonYan.project.third.web;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 说明:调用JASONYAN.PROJECT.FIRST服务
 *
 * @author jasonyan
 * @create 2017-10-30 20:52
 */
@RestController
@RequestMapping("/third")
public class EurekaController {

    public static final String TEST_URL = "http://JASONYAN.PROJECT.FIRST/first/rest?string={string}";

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test_1", method = RequestMethod.GET)
    public ResponseEntity<?> getTest() {
        Map<String, String> map = Maps.newHashMap();
        map.put("string", "eureka_test");
        ResponseEntity<String> forEntity = restTemplate.getForEntity(TEST_URL, String.class, map);
        return ResponseEntity.ok(forEntity);
    }

}
