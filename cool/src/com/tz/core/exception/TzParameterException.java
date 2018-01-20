/**
 * @(#)ParameterException.java 2011-12-20 Copyright 2011 it.kedacom.com, Inc.
 *                             All rights reserved.
 */

package com.tz.core.exception;

/**
 * 
 * TzParameterException
 * 创建人:cool 
 * 时间：2018年1月18日-下午5:36:24 
 * @version 1.0.0
 *
 */

public class TzParameterException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 6417641452178955756L;

	public TzParameterException() {
		super();
	}

	public TzParameterException(String message) {
		super(message);
	}

	public TzParameterException(Throwable cause) {
		super(cause);
	}

	public TzParameterException(String message, Throwable cause) {
		super(message, cause);
	}
}
