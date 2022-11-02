package com.boot.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author YuanXin
 * @ClassName JsonTool
 * @Description
 * @Date 2022/8/28 20:20
 */
public class JsonTool {

    private static ObjectMapper objectMapper;

    public static void setObjectMapper(ObjectMapper mapper) {
        objectMapper = mapper;
    }

    public static String parse(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static <T> T convert(String json, Class<T> clazz) {
        try {
            return (T) objectMapper.readValue(json, new TypeReference<T>() {
            });
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
