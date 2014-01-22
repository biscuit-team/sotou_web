package cn.sotou.web.biz.query;

import java.util.List;

import cn.sotou.web.model.InvestItemWrapper;

public class InvestQueryResult {
	private List<InvestItemWrapper> result;
	private List<PlatformResultCount> statics;

	public List<InvestItemWrapper> getResult() {
		return result;
	}

	public void setResult(List<InvestItemWrapper> result) {
		this.result = result;
	}

	public List<PlatformResultCount> getStatics() {
		return statics;
	}

	public void setStatics(List<PlatformResultCount> statics) {
		this.statics = statics;
	}

}
