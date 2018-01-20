package com.tz.core.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * TzExceptionHandler
 * 创建人:cool 
 * 时间：2018年1月18日-下午5:36:15 
 * @version 1.0.0
 *
 */
public class TzExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ex", ex);
		// 根据不同错误转向不同页面
		if(ex instanceof TzBusinessException) {
			return new ModelAndView("redirect:error.html");
		}else if(ex instanceof TzParameterException) {
			return new ModelAndView("redirect:error.html");
		} else {
			return new ModelAndView("redirect:error.html");
		}
	}
}
