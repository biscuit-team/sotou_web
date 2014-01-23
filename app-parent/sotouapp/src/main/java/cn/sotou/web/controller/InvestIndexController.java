package cn.sotou.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String detail(@PathVariable("id") long id) {
		return "invest/detail";
	}
}
