package cn.sotou.web.biz.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.sotou.dao.model.P2pInvestItem;
import cn.sotou.web.biz.P2pInvestItemFilter;

@Service
public class P2pInvestItemFilterImpl implements P2pInvestItemFilter {

	@Override
	public List<P2pInvestItem> getAll() {
		// TODO Auto-generated method stub
		return Arrays.asList(new P2pInvestItem[] { new P2pInvestItem() });
	}
}
