package cn.sotou.dao;

import java.util.Arrays;
import java.util.List;

import cn.sotou.dao.model.InvestItem;

public class InvestItemDao extends DaoSupport {

	public InvestItemDao() {
	}

	public List<InvestItem> getAll() {

		return Arrays.asList(new InvestItem[] { new InvestItem() });
	}

	@SuppressWarnings("unchecked")
	public List<InvestItem> getByHQL(String hql, int firstResult, int maxResults) {
		return session.createQuery(hql).setFirstResult(firstResult)
				.setMaxResults(maxResults).list();
	}
}
