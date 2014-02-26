package cn.sotou.web.controller.ajax;

import javax.inject.Inject;

import cn.sotou.web.biz.InvestItemDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sotou.web.biz.InvestItemFilterService;
import cn.sotou.web.biz.query.InvestQueryResult;
import cn.sotou.web.biz.query.criteria.InvestQueryCriteria;

@Controller
@RequestMapping("/invest")
public class InvestAjaxController {

	@Inject
	private InvestItemFilterService itemFilter;

    @Inject
    private InvestItemDetailService itemComment;

	@RequestMapping(value = "/query.json", method = RequestMethod.GET)
	public @ResponseBody
	InvestQueryResult filter(InvestQueryCriteria criteria) {
		return itemFilter.get(criteria);
	}
    @RequestMapping(value = "/insertComment", method = RequestMethod.POST)
    public String insertComment(String content,long id) {

        itemComment.insertComment(content,id);
        System.out.println("in ajax call");
         return "forward:/invest/"+id+"/comment";
    }
}
