package cn.sotou.web.controller.ajax.model;

public class RegisterResult extends GeneralResult {
	private long userId = -1;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
