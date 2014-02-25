package cn.sotou.web.controller.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sotou.dao.model.User;
import cn.sotou.web.controller.ajax.model.GeneralResult;
import cn.sotou.web.controller.ajax.model.RegisterResult;

@Controller
@RequestMapping("/user")
public class UserAjaxController {

	@RequestMapping(value = "/register.json", method = RequestMethod.POST)
	public @ResponseBody
	RegisterResult regiest(User user) {
		return new RegisterResult();
	}

	@RequestMapping(value = "/login.json", method = RequestMethod.POST)
	public @ResponseBody
	GeneralResult login(User user) {
		return new GeneralResult();
	}

	@RequestMapping(value = "/valid.json", method = RequestMethod.POST)
	public @ResponseBody
	boolean isValid(User user) {
		return false;
	}
}
