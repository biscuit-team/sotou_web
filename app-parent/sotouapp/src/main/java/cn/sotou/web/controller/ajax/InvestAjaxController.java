package cn.sotou.web.controller.ajax;

import javax.inject.Inject;

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

	@RequestMapping(value = "/query.json", method = RequestMethod.GET)
	public @ResponseBody
	InvestQueryResult filter(InvestQueryCriteria criteria) {
		return itemFilter.get(criteria);
	}
    @RequestMapping(value = "/insertComment", method = RequestMethod.POST)
    public String insertComment(String content,long id) {
        System.out.println("in ajax call");
         return "forward:/invest/"+id+"/comment";
    }
}
