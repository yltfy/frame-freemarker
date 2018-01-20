package com.tz.core.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 获取异常的堆栈信息
 * 
 * ExceptionUtil
 * 创建人:cool 
 * 时间：2018年1月18日-下午7:34:49 
 * @version 1.0.0
 *
 */
public class ExceptionUtil {

	/**
	 * 获取异常的堆栈信息
	 * 
	 * @param t
	 * @return
	 */
	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		try {
			t.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}
	}
}
