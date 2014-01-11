package cn.sotou.web.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Action
@Namespace("/")
@ResultPath(value = "/")
@Result(name = "success", location = "index.html")
public class IndexAction extends ActionSupport {
	public String execute() {
		return SUCCESS;
	}
}
