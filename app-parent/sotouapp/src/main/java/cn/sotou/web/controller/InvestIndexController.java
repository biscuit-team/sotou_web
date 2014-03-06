package cn.sotou.web.controller;

import cn.sotou.dao.model.Comment;
import cn.sotou.web.biz.InvestItemDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sotou.dao.model.InvestItem;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

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
        public String comment(@PathVariable("id") long id,Model model) {
            /*String result =  itemComment.getItemComment(id);
            response.setContentType("text/html;charset=UTF-8");
            try {
                response.getWriter().print(result);
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }*/
        List list = itemComment.getItemComment(id);
        model.addAttribute("allComments",list);
        return "invest/comment_list";
	}

}
