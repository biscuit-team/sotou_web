package cn.sotou.web.biz.query.criteria;

public class InvestQueryCriteria {
	private String oderBy;
	private String orderType = "desc";
	private DoubleFieldRank rate = new DoubleFieldRank();
	private DoubleFieldRank sum = new DoubleFieldRank();;
	private DoubleFieldRank period = new DoubleFieldRank();;
	private int page = 0;
	private int per = 20;
	private long platform = -1;
	private boolean customize;

	public String getOderBy() {
		return oderBy;
	}

	public void setOderBy(String oderBy) {
		this.oderBy = oderBy;
	}

	public DoubleFieldRank getRate() {
		return rate;
	}

	public void setRate(DoubleFieldRank rate) {
		this.rate = rate;
	}

	public DoubleFieldRank getSum() {
		return sum;
	}

	public void setSum(DoubleFieldRank sum) {
		this.sum = sum;
	}

	public DoubleFieldRank getPeriod() {
		return period;
	}

	public void setPeriod(DoubleFieldRank period) {
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

	public long getPlatform() {
		return platform;
	}

	public void setPlatform(long platform) {
		this.platform = platform;
	}

	public boolean isCustomize() {
		return customize;
	}

	public void setCustomize(boolean customize) {
		this.customize = customize;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
}
