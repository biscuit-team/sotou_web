package cn.sotou.web.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/devdemo")
@ResultPath(value = "/devdemo")
@Result(name = "success", location = "index.jsp")
public class DevDemoAction extends ActionSupport {
	@Action("/video")
	public String execute() {
		return SUCCESS;
	}
}
