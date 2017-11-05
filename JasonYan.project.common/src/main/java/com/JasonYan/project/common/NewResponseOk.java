package com.JasonYan.project.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明:对成功后结果集的封装
 *
 * @author jasonyan
 * @create 2017-11-04 23:55
 */
public class NewResponseOk {


    public static ResponseEntity<?> create(Object obj) {

        return ResponseEntity.ok(commonFun(obj));
    }

    public static ResponseEntity<?> create(String key, Object result) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(key, result);
        return ResponseEntity.ok(commonFun(resultMap));
    }

    public static ResponseEntity<?> create(Object obj, Long ttl) {
        return ResponseEntity.status(HttpStatus.OK).header("X-Cache-TTL", String.valueOf(ttl)).body(obj);
    }

    public static ResponseResult commonFun(Object obj) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(200);
        responseResult.setMessage("Success");
        responseResult.setData(obj);
        return responseResult;
    }

    public static class ResponseResult {
        @JsonProperty
        private int code;

        @JsonProperty
        private String message;

        @JsonProperty
        private Object data;

        public ResponseResult() {
        }

        public void setCode(int code) {
            this.code = code;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setData(Object data) {
            this.data = data;
        }

    }
}
