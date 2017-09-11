package com.dfire.util;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiaosuda on 2017/9/8.
 */
@Data
public class JsonResponse implements Serializable {

    private String  message;
    private Object  data;
    private boolean success;

    public JsonResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public JsonResponse(String message, boolean success, Object data) {
        this.message = message;
        this.data = data;
        this.success = success;
    }
}
