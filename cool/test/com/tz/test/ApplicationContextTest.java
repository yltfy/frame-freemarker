/**
 * Tm系统平台
 * TzCmsFront
 * com.tz.test
 * ApplicationContextTest.java
 * 创建人:xuchengfei 
 * 时间：2015年5月26日-下午9:55:34 
 * 2015Tm公司-版权所有
 */
package com.tz.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tz.dao.user.IUserDao;
import com.tz.model.User;

/**
 * 
 * ApplicationContextTest
 * 创建人:xuchengfei 
 * 时间：2015年5月26日-下午9:55:34 
 * @version 1.0.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ApplicationContextTest {
	
	@Autowired
	private ApplicationContext context;
	
	
//	@Test
//	public void handler() throws SQLException{
//		ProxoolDataSource  dataSource = (ProxoolDataSource)context.getBean("dataSource");
//		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
//		ResultSet rs = connection.prepareStatement("select * from tz_user").executeQuery();
//		while (rs.next()) {
//			System.out.println(rs.getInt("id"));
//			System.out.println(rs.getString("account"));
//			System.out.println(rs.getString("password"));
//			System.out.println(rs.getString("username"));
//		}
//	}
	
	/*@Autowired
	private SqlSessionTemplate sqlSession;
	@Test
	public void hander01(){
		List<User> users =sqlSession.selectList("com.tz.dao.user.IUserDao.findUser");
		for (User user : users) {
			System.out.println(user.getAccount()+"==="+user.getUsername());
		}
	}
	
	@Autowired
	private IUserDao userDao;//至少要有一个实现类,它使用动态带来，给产生一个代理类，就执行sql语句和返回对象数据，数据的返回
	
	@Test
	public void hander02(){
		List<User> users = userDao.findUser();
		for (User user : users) {
			System.out.println(user.getAccount()+"==="+user.getUsername());
		}
	}*/
	
}
