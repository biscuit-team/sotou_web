package cn.sotou.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("/")
	public String index(
			@RequestParam(value = "p", required = false) String param,
			Model model) {
		//model.addAttribute("param", param);
		return "index";
	}
}