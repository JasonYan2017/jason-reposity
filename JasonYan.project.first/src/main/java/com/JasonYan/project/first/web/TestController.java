package com.JasonYan.project.first.web;

import com.JasonYan.project.first.service.Task_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 说明:
 *
 * @author jasonyan
 * @create 2017-10-29 16:54
 */
@RestController
@RequestMapping("/first")
public class TestController {

    @Autowired
    private Task_1 task_1;

    @GetMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getString(@RequestParam("string") String string){
        return ResponseEntity.ok(string+task_1.show());
    }
}
