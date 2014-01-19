package cn.sotou.web.biz;

import java.util.List;

import cn.sotou.dao.model.InvestItem;
import cn.sotou.web.biz.query.InvestQueryResult;
import cn.sotou.web.biz.query.criteria.InvestQueryCriteria;

public interface InvestItemFilterService {
	List<InvestItem> getAll();

	List<InvestItem> getByHQLWhere(String hqlWhereFragment);

	InvestQueryResult get(InvestQueryCriteria criteria);
}
