package cn.sotou.web.controller;

import cn.sotou.web.biz.InvestItemDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sotou.dao.model.InvestItem;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
@RequestMapping("/invest")
public class InvestIndexController {
	
	@Inject
	private InvestItemDetailService itemComment;

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

	@RequestMapping("/{id}/comment")
	public @ResponseBody
	String comment(@PathVariable("id") long id) {
		return itemComment.getItemComment(id);
	}
}
