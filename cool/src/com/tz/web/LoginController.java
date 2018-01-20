package com.tz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆入口
 * 
 * LoginController
 * 创建人:cool 
 * 时间：2018年1月18日-下午5:49:06 
 * @version 1.0.0
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
