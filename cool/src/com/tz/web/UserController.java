package com.tz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.Page;
import com.tz.bean.User;
import com.tz.core.exception.ExceptionUtil;
import com.tz.core.exception.TzBusinessException;
import com.tz.service.impl.user.UserServiceImpl;

/**
 * 
 * UserController
 * 创建人:cool 
 * 时间：2018年1月18日-下午5:39:01 
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private  UserServiceImpl userServiceImpl;
	
	@RequestMapping("/index")
	public String index(Page page, Model model){
		try {
			List<User> users = userServiceImpl.listPageUsers(page);
			model.addAttribute("pg", page);
			model.addAttribute("users", users);//将该数据放入作用域中.相当于:request.setAttribute("users",users);
			return "user/index";
		} catch (Exception e) {
			throw new TzBusinessException(ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping("/index2")
	public ModelAndView index2(){
		try {
			System.out.println("进来吗?");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("index2");//你要返回的页面 
			return modelAndView;
		} catch (Exception e) {
			throw new TzBusinessException();
		}
	}
	
}
