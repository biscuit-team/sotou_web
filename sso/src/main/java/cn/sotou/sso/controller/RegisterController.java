package cn.sotou.sso.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import cn.sotou.sso.service.UserDao;

public class RegisterController extends AbstractController {

	private String registerView;

	private UserDao userDao;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// response.setHeader("Cache-Control","no-cache, must-revalidate");

		if ("POST".equals(request.getMethod())) {

			Map<String, Object> model = new HashMap<String, Object>();
			boolean success = false;
			StringBuffer stringBuffer = new StringBuffer();

			String email = request.getParameter("email");

			String username = request.getParameter("email");

			String password = request.getParameter("password");

			String password2 = request.getParameter("password2");

			if ("".equals(email) || "".equals(username) || "".equals(password)
					|| "".equals(password2)) {
				stringBuffer.append("请填写所有字段!");
			} else if (!password.equals(password2)) {
				stringBuffer.append("两次密码不一致!");
			} else if (!password.equals(password2)) {
				stringBuffer.append("两次密码不一致!");
			} else if (userDao.emailRegisted(email)) {
				stringBuffer.append("email已注册!");
			} else if (userDao.userNameRegisted(username)) {
				stringBuffer.append("用户名已注册!");
			} else {
				userDao.addUser(email, username, password);
				success = true;
				//FIXME redirect to redister success view
			}

			model.put("success", success);
			model.put("msg", stringBuffer.toString());

			return new ModelAndView(registerView, model);
		} else {
			return new ModelAndView(registerView);
		}

	}

	public String getRegisterView() {
		return registerView;
	}

	public void setRegisterView(String registerView) {
		this.registerView = registerView;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
