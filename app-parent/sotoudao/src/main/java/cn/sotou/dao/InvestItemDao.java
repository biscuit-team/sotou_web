package cn.sotou.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.sotou.dao.model.InvestItem;

public class InvestItemDao {

	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
		this.session = factory.openSession();
	}

	private Session session;

	public InvestItemDao() {
	}

	public List<InvestItem> getAll() {

		return Arrays.asList(new InvestItem[] { new InvestItem() });
	}

	@SuppressWarnings("unchecked")
	public List<InvestItem> getByHQL(String hql) {
		return session.createQuery(hql).list();
	}
}
