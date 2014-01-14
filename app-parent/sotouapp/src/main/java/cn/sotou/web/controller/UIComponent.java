package cn.sotou.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class UIComponent {
	@RequestMapping("/topNav")
	public String index() {
		return "ui/top";
	}
}
