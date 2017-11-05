package com.JasonYan.project.first.web;

import com.JasonYan.project.common.NewResponseOk;
import com.JasonYan.project.domain.TestPojo;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * 说明:调用JASONYAN.PROJECT.FOURTH服务
 *
 * @author jasonyan
 * @create 2017-11-05 14:35
 */
@RestController
@RequestMapping("/first")
public class RemoteController {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    private final String FOURTH_URL = "http://JASONYAN.PROJECT.FOURTH/test_1"; //测试返回string

    private final String FOURTH_INT_URL = "http://JASONYAN.PROJECT.FOURTH/test_10"; //测试返回int

    private final String FOURTH_OBJECT_URL = "http://JASONYAN.PROJECT.FOURTH/test_11"; //测试返回对象

    private final String FOURTH_MAP_URL = "http://JASONYAN.PROJECT.FOURTH/test_12"; //测试返回map

    private final String FOURTH_LIST_URL = "http://JASONYAN.PROJECT.FOURTH/test_13"; //测试返回list

    private final String FOURTH_ARRAY_URL = "http://JASONYAN.PROJECT.FOURTH/test_14"; //测试返回数组

    private final String FOURTH_RESPONSEENTITY_URL = "http://JASONYAN.PROJECT.FOURTH/test_9"; //测试返回封装类对象

    @GetMapping(value = "/test_1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> remote1() {
        String string = restTemplate.getForObject(FOURTH_URL, String.class);
        return NewResponseOk.create(string);
    }


    @GetMapping(value = "/test_2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> remote2() {
        int value = restTemplate.getForObject(FOURTH_INT_URL, Integer.class);
        return NewResponseOk.create(value);
    }

    @GetMapping(value = "/test_3", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> remote3() {
        TestPojo testPojo = restTemplate.getForObject(FOURTH_OBJECT_URL, TestPojo.class);
        return NewResponseOk.create(testPojo);
    }

    @GetMapping(value = "/test_4", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> remote4() {
        Map<String, Object> map = restTemplate.getForObject(FOURTH_MAP_URL, Map.class);
        return NewResponseOk.create(map);
    }

    @GetMapping(value = "/test_5", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> remote5() {
        List<Map<String, Object>> list = restTemplate.getForObject(FOURTH_LIST_URL, List.class);
        return NewResponseOk.create(list);
    }

    @GetMapping(value = "/test_6", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> remote6() {
        String[] strs = restTemplate.getForObject(FOURTH_ARRAY_URL, String[].class);
        return NewResponseOk.create(strs);
    }

    @GetMapping(value = "/test_7", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> remote7() {
        ResponseEntity<Map> entity = restTemplate.postForEntity(FOURTH_RESPONSEENTITY_URL, null, Map.class);
        return NewResponseOk.create(entity);
    }
}
