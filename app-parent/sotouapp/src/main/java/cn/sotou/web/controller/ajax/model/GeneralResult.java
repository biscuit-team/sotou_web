package cn.sotou.web.controller.ajax.model;

public class GeneralResult {

	public static final GeneralResult SUCCESS = new GeneralResult(true,
			"success");

	public static final GeneralResult FAIL = new GeneralResult(false,
			"unknown fail");

	private boolean success = false;
	private String msg = "fail to proccess the request!";

	public GeneralResult() {

	}

	public GeneralResult(boolean success, String msg) {
		setSuccess(success);
		setMsg(msg);
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
