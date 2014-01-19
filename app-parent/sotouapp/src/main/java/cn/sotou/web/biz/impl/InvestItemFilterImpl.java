package cn.sotou.web.biz.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.sotou.dao.InvestItemDao;
import cn.sotou.dao.model.InvestItem;
import cn.sotou.web.biz.InvestItemFilterService;
import cn.sotou.web.biz.query.InvestQueryResult;
import cn.sotou.web.biz.query.PlatformResultCount;
import cn.sotou.web.biz.query.criteria.InvestQueryCriteria;

@Service
public class InvestItemFilterImpl implements InvestItemFilterService {

	@Inject
	private InvestItemDao investItemDao;

	public InvestItemFilterImpl() {
	}

	@Override
	public List<InvestItem> getAll() {
		return investItemDao.getAll();
	}

	@Override
	public List<InvestItem> getByHQLWhere(String hqlWhereFragment) {

		return investItemDao.getAll();
	}

	@Override
	public InvestQueryResult get(InvestQueryCriteria criteria) {
		InvestQueryResult result = new InvestQueryResult();
		String hql = constractHQL(criteria);
		List<InvestItem> investItems = investItemDao.getByHQL(hql);
		result.setResult(investItems);
		result.setStatics(getPlatfromCount(criteria));

		return result;

	}

	private static String constractHQL(InvestQueryCriteria criteria) {
		return "from InvestItem";
	}

	private List<PlatformResultCount> getPlatfromCount(
			InvestQueryCriteria criteria) {
		// TODO
		PlatformResultCount count = new PlatformResultCount();
		count.setCount(1);
		count.setId(1L);
		count.setName("拍拍贷");
		return Arrays.asList(new PlatformResultCount[] { count });
	}

}
