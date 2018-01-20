package com.tz.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 响应结构
 * 
 * JsonUtils
 * 创建人:cool 
 * 时间：2018年1月18日-下午7:35:34 
 * @version 1.0.0
 *
 */
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

   /**
    * 将对象转换成json字符串
    * 方法名：objectToJson
    * 创建人：cool 
    * 时间：2018年1月18日-下午7:36:02 
    * 手机:18850149410
    * @param data
    * @return String
    * @exception 
    * @since  1.0.0
    */
    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 将json结果集转化为对象
     * 方法名：jsonToPojo
     * 创建人：cool 
     * 时间：2018年1月18日-下午7:35:50 
     * 手机:18850149410
     * @param jsonData
     * @param beanType
     * @return T
     * @exception 
     * @since  1.0.0
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将json数据转换成pojo对象list
     * 方法名：jsonToList
     * 创建人：cool 
     * 时间：2018年1月18日-下午7:36:13 
     * 手机:18850149410
     * @param jsonData
     * @param beanType
     * @return List<T>
     * @exception 
     * @since  1.0.0
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    
}
