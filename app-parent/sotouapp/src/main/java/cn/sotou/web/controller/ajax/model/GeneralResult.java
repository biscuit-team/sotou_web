package cn.sotou.web.controller.ajax.model;

public class GeneralResult {
	private boolean success = false;
	private String msg = "fail to proccess the request!";

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
