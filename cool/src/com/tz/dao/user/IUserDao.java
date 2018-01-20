package com.tz.dao.user;

import java.util.List;

import com.tz.bean.Page;
import com.tz.bean.User;

/**
 * 
 * IUserDao
 * 创建人:cool 
 * 时间：2018年1月18日-下午5:38:14 
 * @version 1.0.0
 *
 */
public interface IUserDao {
	
	public List<User> listPageUsers(Page page);
}
