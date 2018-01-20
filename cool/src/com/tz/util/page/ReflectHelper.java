package com.tz.util.page;

import java.lang.reflect.Field;

/**
 * ReflectHelper 反射工具类
 * 创建人:冯小梁 时间：2017年11月29日-下午4:04:28 
 * @version 1.0.0
 *
 */
public class ReflectHelper {
	/**
	 * 获取obj对象fieldName的Field
	 * 方法名：getFieldByFieldName
	 * 创建人：冯小梁 
	 * 时间：2017年11月29日-下午4:04:19 
	 * 手机:18850149410
	 * @param obj
	 * @param fieldName
	 * @return Field
	 * @exception 
	 * @since  1.0.0
	 */
	public static Field getFieldByFieldName(Object obj, String fieldName) {
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
			}
		}
		return null;
	}

	/**
	 * 获取obj对象fieldName的属性值
	 * 方法名：getValueByFieldName
	 * 创建人：冯小梁 
	 * 时间：2017年11月29日-下午4:04:05 
	 * 手机:18850149410
	 * @param obj
	 * @param fieldName
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException Object
	 * @exception 
	 * @since  1.0.0
	 */
	public static Object getValueByFieldName(Object obj, String fieldName)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Field field = getFieldByFieldName(obj, fieldName);
		Object value = null;
		if(field!=null){
			if (field.isAccessible()) {
				value = field.get(obj);
			} else {
				field.setAccessible(true);
				value = field.get(obj);
				field.setAccessible(false);
			}
		}
		return value;
	}

	/**
	 * 设置obj对象fieldName的属性值
	 * 方法名：setValueByFieldName
	 * 创建人：冯小梁 
	 * 时间：2017年11月29日-下午4:03:50 
	 * 手机:18850149410
	 * @param obj
	 * @param fieldName
	 * @param value
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void setValueByFieldName(Object obj, String fieldName,
			Object value) throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Field field = obj.getClass().getDeclaredField(fieldName);
		if (field.isAccessible()) {
			field.set(obj, value);
		} else {
			field.setAccessible(true);
			field.set(obj, value);
			field.setAccessible(false);
		}
	}
}
