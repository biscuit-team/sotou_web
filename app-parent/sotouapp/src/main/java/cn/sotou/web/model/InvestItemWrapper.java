package cn.sotou.web.model;

import cn.sotou.dao.model.InvestItem;

@SuppressWarnings("serial")
public class InvestItemWrapper extends InvestItem {
	private InvestItemExtraInfoWrapper extra;

	public InvestItemExtraInfoWrapper getExtra() {
		return extra;
	}

	public void setExtra(InvestItemExtraInfoWrapper extra) {
		this.extra = extra;
	}
}
