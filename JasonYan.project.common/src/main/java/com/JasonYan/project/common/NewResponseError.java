package com.JasonYan.project.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;

/**
 * 说明:对失败后的结果级的封装
 *
 * @author jasonyan
 * @create 2017-11-05 00:35
 */
public class NewResponseError {

    public static ResponseEntity<?> error(String message) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setCode(400);
        responseResult.setMessage(message);
        return ResponseEntity.ok(responseResult);
    }

    public static ResponseEntity<?> error(int code,String message) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setCode(code);
        responseResult.setMessage(message);
        return ResponseEntity.ok(responseResult);
    }

    public static class ResponseResult {

        public ResponseResult() {
        }

        @JsonProperty
        private int code;

        @JsonProperty
        private String message;

        public void setCode(int code) {
            this.code = code;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
