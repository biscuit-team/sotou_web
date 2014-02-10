package cn.sotou.web.controller.ajax;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.sotou.web.controller.ajax.model.GeneralResult;

public class StartInvestAjaxController {

	@RequestMapping(value = "/star.json", method = RequestMethod.POST)
	public GeneralResult start(@RequestParam("investId") long investId) {
		return GeneralResult.FAIL;
	}

	@RequestMapping(value = "/remove/star.json", method = RequestMethod.POST)
	public GeneralResult remove(@RequestParam("investId") long investId) {
		return GeneralResult.FAIL;
	}

}
