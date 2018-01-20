package com.tz.core.des;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * EncryptPropertyPlaceholderConfigurer
 * 创建人:cool 
 * 时间：2018年1月18日-下午5:35:37 
 * @version 1.0.0
 *
 */
public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	private String[] encryptPropNames = { "db.username", "db.password" };

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptProp(propertyName)) {
			String decryptValue = DESUtils.getDecryptString(propertyValue);
			return decryptValue;
		} else {
			return propertyValue;
		}
	}

	/**
	 * 判断是否是加密的属性
	 * 
	 * @param propertyName
	 * @return
	 */
	private boolean isEncryptProp(String propertyName) {
		for (String encryptPropName : encryptPropNames) {
			if (encryptPropName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}
