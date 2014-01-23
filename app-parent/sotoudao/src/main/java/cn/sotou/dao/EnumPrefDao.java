package cn.sotou.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.SessionFactory;

import cn.sotou.dao.model.EnsureType;
import cn.sotou.dao.model.RepayType;
import cn.sotou.dao.model.SiteInfo;
import cn.sotou.dao.model.StakeType;

public class EnumPrefDao extends DaoSupport {

	private final String iD_FIELD = "id";

	private Map<Long, RepayType> repayTypeMap = new HashMap<Long, RepayType>();
	private Map<Long, StakeType> stakeTypeMap = new HashMap<Long, StakeType>();
	private Map<Long, EnsureType> enSureTypeMap = new HashMap<Long, EnsureType>();
	private Map<Long, SiteInfo> siteInfoMap = new HashMap<Long, SiteInfo>();

	@Override
	public void setFactory(SessionFactory factory) {
		super.setFactory(factory);
		reload();
	}

	public void reload() {

		repayTypeMap = readPref(RepayType.class);
		stakeTypeMap = readPref(StakeType.class);
		enSureTypeMap = readPref(EnsureType.class);
		siteInfoMap = readPref(SiteInfo.class);
	}

	public Map<Long, RepayType> getRepayTypeMap() {
		return repayTypeMap;
	}

	public Map<Long, StakeType> getStakeTypeMap() {
		return stakeTypeMap;
	}

	public Map<Long, EnsureType> getEnSureTypeMap() {
		return enSureTypeMap;
	}

	public Map<Long, SiteInfo> getSiteInfoMap() {
		return siteInfoMap;
	}

	@SuppressWarnings("unchecked")
	private <T> Map<Long, T> readPref(Class<T> clazz) {
		String hql = "from " + clazz.getName();
		List<T> list = session.createQuery(hql).list();
		try {
			return this.listToMap(list);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private <T> Map<Long, T> listToMap(List<T> list)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Map<Long, Object> map = new HashMap<Long, Object>();

		for (T t : list) {
			String id = BeanUtils.getProperty(t, iD_FIELD);
			long id_value = Long.parseLong(id);
			map.put(id_value, t);
		}
		return (Map<Long, T>) map;

	}

}
