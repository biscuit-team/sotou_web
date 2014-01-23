package cn.sotou.web.biz.query.criteria;

public class InvestQueryCriteria {
	private OrderField oderBy;
	private FieldRank rate;
	private FieldRank sum;
	private FieldRank period;
	private int page;
	private int per;

	public OrderField getOderBy() {
		return oderBy;
	}

	public void setOderBy(OrderField oderBy) {
		this.oderBy = oderBy;
	}

	public FieldRank getRate() {
		return rate;
	}

	public void setRate(FieldRank rate) {
		this.rate = rate;
	}

	public FieldRank getSum() {
		return sum;
	}

	public void setSum(FieldRank sum) {
		this.sum = sum;
	}

	public FieldRank getPeriod() {
		return period;
	}

	public void setPeriod(FieldRank period) {
		this.period = period;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer() {
		return per;
	}

	public void setPer(int per) {
		this.per = per;
	}
}
