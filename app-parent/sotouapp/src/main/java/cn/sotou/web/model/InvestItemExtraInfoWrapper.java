package cn.sotou.web.model;

import cn.sotou.dao.model.EnsureType;
import cn.sotou.dao.model.RepayType;
import cn.sotou.dao.model.SiteInfo;
import cn.sotou.dao.model.StakeType;

public class InvestItemExtraInfoWrapper {
	private RepayType repayType;
	private StakeType stakeType;
	private EnsureType enSureType;
	private SiteInfo siteInfo;

	public RepayType getRepayType() {
		return repayType;
	}

	public void setRepayType(RepayType repayType) {
		this.repayType = repayType;
	}

	public StakeType getStakeType() {
		return stakeType;
	}

	public void setStakeType(StakeType stakeType) {
		this.stakeType = stakeType;
	}

	public EnsureType getEnSureType() {
		return enSureType;
	}

	public void setEnSureType(EnsureType enSureType) {
		this.enSureType = enSureType;
	}

	public SiteInfo getSiteInfo() {
		return siteInfo;
	}

	public void setSiteInfo(SiteInfo siteInfo) {
		this.siteInfo = siteInfo;
	}

}
