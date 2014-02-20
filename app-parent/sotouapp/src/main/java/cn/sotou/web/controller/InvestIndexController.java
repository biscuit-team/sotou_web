package cn.sotou.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sotou.dao.model.InvestItem;

@Controller
@RequestMapping("/invest")
public class InvestIndexController {

	@RequestMapping("/")
	public String index() {
		return "invest/index";
	}

	@RequestMapping("/filter")
	public String filter() {
		return "invest/filter";
	}

	@RequestMapping("/{id}")
	public String detail(@PathVariable("id") long id, Model model) {
		model.addAttribute("investItem", new InvestItem());
		return "invest/detail";
	}
}
