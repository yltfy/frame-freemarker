package com.tz.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.User;
import com.tz.bean.Page;
import com.tz.dao.user.IUserDao;

/**
 * 
 * UserServiceImpl
 * 创建人:cool 
 * 时间：2018年1月18日-下午5:38:43 
 * @version 1.0.0
 *
 */
@Service
public class UserServiceImpl {

	@Autowired
	private IUserDao userDao;
	
	public List<User> listPageUsers(Page page){
		return userDao.listPageUsers(page);
	}
}
