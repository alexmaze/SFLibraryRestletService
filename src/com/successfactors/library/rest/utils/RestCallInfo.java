package com.successfactors.library.rest.utils;

import java.util.HashMap;

public class RestCallInfo {
	
	public static final String REST_STATUS = "restStatus";
	public static final String REST_ERROR_CODE = "restErrorCode";
	
	public enum RestCallStatus {
		success,
		fail
	}
	
	public enum RestCallErrorCode {
		no_error,
		need_login,
		wrong_email_password,
		json_format_error,
	}

	
	public static HashMap<String, Object> getInitRestCallInfo(RestCallStatus restStatus, RestCallErrorCode errorCode) {
		HashMap<String, Object> ret = new HashMap<String, Object>();
		ret.put(REST_STATUS, (restStatus == null)?"":restStatus.toString());
		ret.put(REST_ERROR_CODE, (errorCode == null)?"":errorCode.toString());
		return ret;
	}
	
	
}
