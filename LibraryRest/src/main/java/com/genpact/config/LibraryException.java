package com.genpact.config;

import org.springframework.stereotype.Component;

/**
 * This is a custom Exception class for the application.
 * 
 * @author Reetesh R Nayak
 *
 */
@Component
public class LibraryException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errCode;
	private String errMsg;

	public LibraryException() {
	}

	public LibraryException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}