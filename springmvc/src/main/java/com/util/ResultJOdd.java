package com.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class ResultJOdd {
    private boolean iserror;
    private String message;
    private Object data;
    private HashMap<String, String> errordata;

    public ResultJOdd() {
    }

    public boolean isIserror() {
        return this.iserror;
    }

    public void setIserror(boolean iserror) {
        this.iserror = iserror;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HashMap<String, String> getErrordata() {
        return this.errordata;
    }

    public void setErrordata(HashMap<String, String> errordata) {
        this.errordata = errordata;
    }

    public ResultJOdd addData(Object key, Object value) {
        if (this.data == null) {
            this.data = new HashMap();
        }

        if (this.data instanceof Map) {
            ((Map)this.data).put(key, value);
        }

        return this;
    }

    public static com.util.ResultJOdd getResultFromErrors(Errors errors) {
        com.util.ResultJOdd rj = new com.util.ResultJOdd();
        if (errors != null && errors.hasErrors()) {
            HashMap<String, String> errorMap = new HashMap();
            List<FieldError> errorlist = errors.getFieldErrors();
            Iterator i$ = errorlist.iterator();

            while(i$.hasNext()) {
                FieldError error = (FieldError)i$.next();
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            rj.setErrordata(errorMap);
            rj.setIserror(true);
        }

        return rj;
    }

    public static com.util.ResultJOdd getDefaultResult(Object data) {
        return getDefaultResult(data, "保存成功");
    }

    public static com.util.ResultJOdd getDefaultResult(Object data, String message) {
        com.util.ResultJOdd rj = new com.util.ResultJOdd();
        rj.setData(data);
        rj.setIserror(false);
        rj.setMessage(message);
        return rj;
    }

    public static com.util.ResultJOdd getErrorResult(Object data, String message) {
        com.util.ResultJOdd rj = new com.util.ResultJOdd();
        rj.setData(data);
        rj.setIserror(true);
        rj.setMessage(message);
        return rj;
    }

    public static com.util.ResultJOdd getErrorResult(Object data) {
        return getErrorResult(data, "保存出错");
    }

    public static com.util.ResultJOdd getNamedResult(HashMap map) {
        return getDefaultResult(map);
    }

    public static com.util.ResultJOdd getNamedResult(Object... data) {
        HashMap<String, Object> map = new HashMap();
        Object[] arr$ = data;
        int len$ = data.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Object dataO = arr$[i$];
            if (dataO != null) {
                map.put(dataO.getClass().getSimpleName().toLowerCase(), dataO);
            }
        }

        return getNamedResult(map);
    }

    public static <M> com.util.ResultJOdd getNamedResult(String name, M data) {
        HashMap<String, M> map = new HashMap();
        map.put(name, data);
        return getNamedResult(map);
    }
}

