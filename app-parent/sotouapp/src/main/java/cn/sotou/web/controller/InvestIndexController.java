package cn.sotou.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sotou.web.biz.P2pInvestItemFilter;

@Controller
@RequestMapping("/invest")
public class InvestIndexController {

	@Inject
	private P2pInvestItemFilter itemFilter;

	@RequestMapping("/")
	public String index() {
		itemFilter.getAll();
		return "invest/index";
	}
	
	@RequestMapping("/filter")
	public String filter() {
		itemFilter.getAll();
		return "invest/filter";
	}
}
