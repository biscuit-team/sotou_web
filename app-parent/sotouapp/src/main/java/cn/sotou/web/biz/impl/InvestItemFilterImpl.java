package cn.sotou.web.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import cn.sotou.dao.EnumPrefDao;
import cn.sotou.dao.InvestItemDao;
import cn.sotou.dao.model.InvestItem;
import cn.sotou.web.biz.InvestItemFilterService;
import cn.sotou.web.biz.query.InvestQueryResult;
import cn.sotou.web.biz.query.PlatformResultCount;
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
		List<InvestItem> investItems = investItemDao.getByHQL(hql);

		result.setResult(wrapResult(investItems));
		result.setStatics(getPlatfromCount(criteria));
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

		type.setEnSureType(enumPrefDao.getEnSureTypeMap().get(
				investItem.getEnsuretype()));
		type.setSiteInfo(enumPrefDao.getSiteInfoMap().get(
				investItem.getSourcesiteid()));
		type.setStakeType(enumPrefDao.getStakeTypeMap().get(
				investItem.getStaketype()));

		wrapper.setExtra(type);
		return wrapper;
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
