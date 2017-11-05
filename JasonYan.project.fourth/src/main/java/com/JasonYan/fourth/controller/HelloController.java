package com.JasonYan.fourth.controller;

import com.JasonYan.project.common.NewResponseOk;
import com.JasonYan.project.domain.TestPojo;
import com.google.common.collect.Lists;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明:
 *
 * @author jasonyan
 * @create 2017-11-04 22:07
 */
@RestController
public class HelloController {

    //返回一个string
    @RequestMapping(value = "/test_1", method = RequestMethod.GET)
    public String show() {
        return "Fourth,Success";
    }

    //用对象接受参数
    @PostMapping(value = "test_2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getData(@RequestBody TestPojo testPojo) {
        System.out.println(testPojo);
        return "Success";
    }

    //单独的list接受参数，传递值为[1,2,3,4]数组
    @PostMapping(value = "/test_3", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getList(@RequestBody List<String> list) {
        System.out.println(list);
        return "Success";
    }

    //数组接受,传递值为[1,2,3,4,"Jason","Tom"]数组
    @PostMapping(value = "/test_4", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getList1(@RequestBody String[] strings) {
        System.out.println(Arrays.toString(strings));
        return "Success";
    }

    //传递值为多个对象的集合，[{},{}]
    @PostMapping(value = "/test_5", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getListMap(@RequestBody List<Map<String, Object>> list) {
        System.out.println(list);
        return "Success";
    }

    //路径参数和传值参数，@RequestParam默认为true必传
    @GetMapping(value = "/test_6/{ss}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getString(@PathVariable("ss") String str, @RequestParam(value = "name") String name) {
        System.out.println(str + "\n" + name);
        return "Success";
    }

    //test_5和test_6效果一致,必传值
    @GetMapping(value = "/test_7/{ss}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getString1(@PathVariable("ss") String str, @RequestParam(required = true, value = "name") String name) {
        System.out.println(str + "\n" + name);
        return "Success";
    }

    //可以不用传值，设置了默认值
    @GetMapping(value = "/test_8/{ss}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getString2(@PathVariable("ss") String str, @RequestParam(required = false, value = "name", defaultValue = "JS") String name) {
        System.out.println(str + "\n" + name);
        return "Success";
    }


    //封装类返回
    @PostMapping(value = "/test_9", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getTest() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("1001011", "56");
        maps.put("device_id", "99908202duw3");
        maps.put("item_code", 13453355);
        return NewResponseOk.create(maps);
    }

    //直接返回一个int
    @GetMapping(value = "/test_10", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int responseInteger() {
        return 666666;
    }

    //直接返回一个对象
    @GetMapping(value = "/test_11", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TestPojo responseObject() {
        TestPojo testPojo = new TestPojo();
        testPojo.setId(1);
        testPojo.setProduct_id(123456L);
        testPojo.setProduct_name("Iphone x");
        testPojo.setProduct_price(88888.0);
        testPojo.setProduct_sale_qty(234);
        return testPojo;
    }

    //直接返回一个map
    @GetMapping(value = "/test_12", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Object> responseMap() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("fourth", "Success");
        maps.put("device_id", 1224444434);
        return maps;
    }

    //直接返回一个List
    @GetMapping(value = "/test_13", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Map<String, Object>> responseList() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("fourth", "Success");
        maps.put("device_id", 1224444434);

        List<Map<String, Object>> list = Lists.newArrayList();
        list.add(maps);
        return list;
    }

    //直接返回一个数组
    @GetMapping(value = "/test_14", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String[] responseArray() {
        String[] sts = {"Jason", "Tome"};
        return sts;
    }

}
