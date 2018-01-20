package com.tz.core;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

/**
 * 获取服务器的根目录
 * 
 * TmBasePathExposer
 * 创建人:cool 
 * 时间：2018年1月18日-下午5:36:34 
 * @version 1.0.0
 *
 */
public class TmBasePathExposer implements ServletContextAware {

	private ServletContext servletContext;
	private String basePath;

	public void init() {
		//servletContext 应用上下文--application--
		//端口，参数，请求头都放在request对象中....
		servletContext.setAttribute("basePath",basePath==null?servletContext.getContextPath():basePath);
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
