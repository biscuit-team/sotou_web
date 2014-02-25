package cn.sotou.web.biz.query.criteria;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class HqlBuilder {

	private static final Map<String, String> ORDER_FIRLD_MAP = ImmutableMap
			.<String, String> builder().put("sum", "totalmoney")
			.put("process", "process").put("rate", "yearprofitrate")
			.put("period", "duration").build();

	public static String buildHql(InvestQueryCriteria criteria) {

		StringBuffer sb = new StringBuffer();

		sb.append("from InvestItem where process < 100 ");

		buildWhereHql(sb, criteria);

		if (criteria.getOrderBy() != null
				&& !criteria.getOrderBy().equals("default")) {
			sb.append(" order by ")
					.append(ORDER_FIRLD_MAP.get(criteria.getOrderBy()))
					.append(" ").append(criteria.getOrderType());
		}

		return sb.toString();
	}

	public static String buildGroupHql(InvestQueryCriteria criteria) {
		StringBuffer sb = new StringBuffer();

		sb.append("select new map( sourcesiteid as id,count(*) as n) from InvestItem where process < 100 ");

		buildWhereHql(sb, criteria);

		sb.append(" group by sourcesiteid");

		return sb.toString();
	}

	private static void buildWhereHql(StringBuffer sb,
			InvestQueryCriteria criteria) {
		// 利率
		sb.append("and yearprofitrate >= ").append(criteria.getRate().getMin());
		if (criteria.getRate().getMax() > 0) {
			sb.append(" and yearprofitrate <= ").append(
					criteria.getRate().getMax());
		}

		// 总额
		sb.append(" and totalmoney >= ").append(criteria.getSum().getMin());
		if (criteria.getSum().getMax() > 0) {
			sb.append(" and totalmoney <= ").append(criteria.getSum().getMax());
		}

		// 周期
		sb.append(" and duration >= ").append(criteria.getPeriod().getMin());
		if (criteria.getPeriod().getMax() > 0) {
			sb.append(" and duration <= ")
					.append(criteria.getPeriod().getMax());
		}

		if (criteria.getPlatform() > -1) {
			sb.append(" and sourcesiteid = ").append(criteria.getPlatform());
		}
	}
}
