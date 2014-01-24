package cn.sotou.web.biz.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import cn.sotou.dao.EnumPrefDao;
import cn.sotou.dao.InvestItemDao;
import cn.sotou.dao.model.InvestItem;
import cn.sotou.web.biz.InvestItemFilterService;
import cn.sotou.web.biz.query.InvestQueryResult;
import cn.sotou.web.biz.query.PlatformResultCount;
import cn.sotou.web.biz.query.criteria.HqlBuilder;
import cn.sotou.web.biz.query.criteria.InvestQueryCriteria;
import cn.sotou.web.model.InvestItemExtraInfoWrapper;
import cn.sotou.web.model.InvestItemWrapper;

@Service
public class InvestItemFilterImpl implements InvestItemFilterService {

	@Inject
	private InvestItemDao investItemDao;

	@Inject
	private EnumPrefDao enumPrefDao;

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
		List<InvestItem> investItems = investItemDao.getByHQL(hql,
				criteria.getPage() * criteria.getPer(), criteria.getPer());

		result.setResult(wrapResult(investItems));
		result.setStatics(getPlatfromCount(HqlBuilder.buildGroupHql(criteria)));
		return result;

	}

	private List<InvestItemWrapper> wrapResult(List<InvestItem> investItems) {
		List<InvestItemWrapper> list = new ArrayList<InvestItemWrapper>();
		for (InvestItem investItem : investItems) {

			InvestItemWrapper wrapper = this.wrapInvestItem(investItem);
			list.add(wrapper);

		}
		return list;
	}

	private InvestItemWrapper wrapInvestItem(InvestItem investItem) {

		InvestItemWrapper wrapper = new InvestItemWrapper();

		// copy properties from investItem
		try {
			BeanUtils.copyProperties(wrapper, investItem);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add extra information
		InvestItemExtraInfoWrapper type = new InvestItemExtraInfoWrapper();

		// FIXME reload on need
		// enumPrefDao.reload();

		type.setEnSureType(enumPrefDao.getEnSureTypeMap().get(
				new Long(investItem.getEnsuretype())));
		type.setStakeType(enumPrefDao.getStakeTypeMap().get(
				new Long(investItem.getStaketype())));
		type.setSiteInfo(enumPrefDao.getSiteInfoMap().get(
				investItem.getSourcesiteid()));
		type.setRepayType(enumPrefDao.getRepayTypeMap().get(
				new Long(investItem.getWaytorepay())));

		wrapper.setExtra(type);
		return wrapper;
	}

	private static String constractHQL(InvestQueryCriteria criteria) {
		return HqlBuilder.buildHql(criteria);
	}

	@SuppressWarnings("rawtypes")
	private List<PlatformResultCount> getPlatfromCount(String hql) {
		
		List<PlatformResultCount> counts = new ArrayList<PlatformResultCount>();
		
		List l = investItemDao.queryHql(hql);
		l.size();
		
		PlatformResultCount count1 = new PlatformResultCount();
		count1.setName("全部");
		count1.setId(-1L);
		counts.add(count1);
		
		
		int sum = 0;
		for (Object object : l) {
			Map map = (Map)object;
			PlatformResultCount count = new PlatformResultCount();
			count.setCount(((Long)map.get("n")).intValue());
			count.setId((Long)map.get("id"));
			count.setName(enumPrefDao.getSiteInfoMap().get((Long)(map.get("id"))).getSourcesitecn());
			counts.add(count);
			sum+=(Long)map.get("n");
		}
		
		counts.get(0).setCount(sum);
		return counts;
	}
}
