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

	private Map<Integer, RepayType> repayTypeMap;
	private Map<Integer, StakeType> stakeTypeMap;
	private Map<Integer, EnsureType> enSureTypeMap;
	private Map<Integer, SiteInfo> siteInfoMap;

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

	public Map<Integer, RepayType> getRepayTypeMap() {
		return repayTypeMap;
	}

	public Map<Integer, StakeType> getStakeTypeMap() {
		return stakeTypeMap;
	}

	public Map<Integer, EnsureType> getEnSureTypeMap() {
		return enSureTypeMap;
	}

	public Map<Integer, SiteInfo> getSiteInfoMap() {
		return siteInfoMap;
	}

	@SuppressWarnings("unchecked")
	private <T> Map<Integer, T> readPref(Class<T> clazz) {
		String hql = "from " + clazz.getName();
		List<T> list = session.createCriteria(hql).list();
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
	private <T> Map<Integer, T> listToMap(List<T> list)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Map<Integer, Object> map = new HashMap<Integer, Object>();

		for (T t : list) {
			String id = BeanUtils.getProperty(t, iD_FIELD);
			int id_value = Integer.parseInt(id);
			map.put(id_value, t);
		}
		return (Map<Integer, T>) map;

	}

}
