package com.tz.core.dao;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({ @Signature(type = Executor.class, method = "query", 
	args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }),
    @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class })})
//如果你拦截增删改那么只需要配置一个method="update" 
/**
 * 
 * ExamplePlugin
 * 创建人:cool 
 * 时间：2018年1月18日-下午5:34:58 
 * @version 1.0.0
 *
 */
public class ExamplePlugin implements Interceptor {
	private Log logger = LogFactory.getLog(ExamplePlugin.class);
	
	public Object intercept(Invocation invocation) throws Throwable {
		logger.info("sql执行了拦截了.....");
		logger.info("=================="+invocation);
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		logger.info(target);
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}
}