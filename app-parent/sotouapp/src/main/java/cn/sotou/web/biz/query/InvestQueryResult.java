package cn.sotou.web.biz.query;

import java.util.List;

import cn.sotou.dao.model.InvestItem;

public class InvestQueryResult {
	private List<InvestItem> result;
	private List<PlatformResultCount> statics;

	public List<InvestItem> getResult() {
		return result;
	}

	public void setResult(List<InvestItem> result) {
		this.result = result;
	}

	public List<PlatformResultCount> getStatics() {
		return statics;
	}

	public void setStatics(List<PlatformResultCount> statics) {
		this.statics = statics;
	}
}
