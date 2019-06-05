package com.uranus.transition.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** @author XiaoPeng */
public class JacksonUtil {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  private static final XmlMapper XML_MAPPER = new XmlMapper();

  static {
    OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    OBJECT_MAPPER.configure(JsonParser.Feature.IGNORE_UNDEFINED, true);
    OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
    OBJECT_MAPPER.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    //    OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    OBJECT_MAPPER
        .getSerializerProvider()
        .setNullValueSerializer(
            new JsonSerializer<Object>() {
              @Override
              public void serialize(
                  Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                  throws IOException {
                jsonGenerator.writeNull();
              }
            });
    OBJECT_MAPPER.registerModule(new JavaTimeModule());
  }
  static {
    XML_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
    XML_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    XML_MAPPER.registerModule(new JavaTimeModule());
  }

  private JacksonUtil() {}

  public static ObjectMapper getInstance() {
    return OBJECT_MAPPER;
  }

  /**
   * javaBean、列表数组转换为json字符串
   *
   * @param obj 数据对象
   * @return String
   * @throws Exception 转换异常
   */
  public static String objToJson(Object obj) throws Exception {
    return OBJECT_MAPPER.writeValueAsString(obj);
  }

  public static String objToXml(Object obj) throws Exception {
    return XML_MAPPER.writeValueAsString(obj);
  }
  /**
   * json 转JavaBean
   *
   * @param jsonString 字符串
   * @param clazz 类
   * @param <T> 转换类型
   * @return T
   * @throws Exception 转换异常
   */
  public static <T> T jsonToPojo(String jsonString, Class<T> clazz) throws Exception {
    OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    return OBJECT_MAPPER.readValue(jsonString, clazz);
  }

  /**
   * json字符串转换为map
   *
   * @param jsonString 字符串
   * @return Map
   * @throws Exception 转换异常
   */
  public static Map jsonToMap(String jsonString) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(jsonString, Map.class);
  }

  /**
   * json字符串转换为map
   *
   * @param jsonString 字符串
   * @param typeReference 类
   * @param clazz 转换类型
   * @return T
   * @throws Exception 转换异常
   */
  public static <T> Map<String, T> jsonToMap(
      String jsonString, TypeReference typeReference, Class<T> clazz) throws Exception {
    Map<String, Map<String, Object>> map = OBJECT_MAPPER.readValue(jsonString, typeReference);
    Map<String, T> result = new HashMap<>();
    for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
      result.put(entry.getKey(), mapToPojo(entry.getValue(), clazz));
    }
    return result;
  }

  /**
   * 与javaBean json数组字符串转换为列表
   *
   * @param jsonArrayStr 字符串
   * @param typeReference 类
   * @return List
   * @throws Exception 转换异常
   */
  public static <T> T jsonToList(String jsonArrayStr, TypeReference<T> typeReference)
      throws Exception {
    return OBJECT_MAPPER.readValue(jsonArrayStr, typeReference);
  }

  /**
   * map 转JavaBean
   *
   * @param map 源
   * @param clazz 类
   * @param <T> 转换类型
   * @return T
   */
  public static <T> T mapToPojo(Map map, Class<T> clazz) {
    return OBJECT_MAPPER.convertValue(map, clazz);
  }

  /**
   * map 转json
   *
   * @param map 源
   * @return string
   * @throws Exception 转换异常
   */
  public static String mapToJson(Map map) throws Exception {
    return OBJECT_MAPPER.writeValueAsString(map);
  }

  /**
   * bean 类型转换
   *
   * @param obj 源
   * @param clazz 类
   * @param <T> 转换类型
   * @return T
   */
  public static <T> T objToPojo(Object obj, Class<T> clazz) {
    return OBJECT_MAPPER.convertValue(obj, clazz);
  }
}
