package cn.sotou.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class DaoSupport {
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
		this.session = factory.openSession();
	}

	protected Session session;
}
