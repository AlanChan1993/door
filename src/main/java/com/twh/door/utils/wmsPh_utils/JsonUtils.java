package com.twh.door.utils.wmsPh_utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
    }

    public static String toJsonStr(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static  <T> T getJsonStrToObj(String jsonStr,Class<T> clazz){
        try {
            return objectMapper.readValue(jsonStr,clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String,Object> toMap(String jsonStr){
        try {
            return objectMapper.readValue(jsonStr,Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String,Object> beanToJson(Object obj){
       return objectMapper.convertValue(obj, Map.class);
    }

    public static void webReturnJson(HttpServletResponse response, Object obj){
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String jsonStr = toJsonStr(obj);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(jsonStr);
        } catch (Exception ignore) {

        }finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }


}
