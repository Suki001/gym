package com.bc.wb.gym.base.utils;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;

public class HttpResultUtil {
    public static HttpResult success(Object object){
        HttpResult result = new HttpResult();
        Object res;
        if(object==null || object instanceof JSONArray || object instanceof ArrayList || object.getClass().isArray()){
            res = object;
        }else{
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(object);
            res = jsonArray;
        }
        result.setCode(0);
        result.setMsg("success");
        result.setData(res);
        return result;
    }
    public static HttpResult success(){
        HttpResult result  = new HttpResult();
        result.setCode(0);
        result.setMsg("success");
        result.setData(new ArrayList<>());
        return result;
    }
}
