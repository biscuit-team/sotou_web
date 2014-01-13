package cn.sotou.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import cn.sotou.web.biz.P2pInvestItemFilter;

@Controller
public class InvestIndexController {
	
	@Inject
	private P2pInvestItemFilter itemFilter;
	
	public String index() {
		itemFilter.getClass();
		return "invest/index";
	}
}
