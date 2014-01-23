package cn.sotou.web.biz.query.criteria;

public enum OrderField {
	sum("totalmoney"), process("process"), rate("yearprofitrate"), period(
			"duration");

	private String field;

	private OrderField(String dbField) {
		this.field = dbField;
	}

	@Override
	public String toString() {
		return field;
	}
}
