package cn.sotou.web.biz.query.criteria;

public class HqlBuilder {
	public static String buildHql(InvestQueryCriteria criteria) {

		StringBuffer sb = new StringBuffer();

		sb.append("from InvestItem where ");

		// 利率
		sb.append("yearprofitrate > ").append(criteria.getRate().getMin());
		if (criteria.getRate().getMax() > 0) {
			sb.append(" and yearprofitrate < ").append(
					criteria.getRate().getMax());
		}

		// 总额
		sb.append(" and totalmoney > ").append(criteria.getSum().getMin());
		if (criteria.getSum().getMax() > 0) {
			sb.append(" and totalmoney < ").append(criteria.getSum().getMax());
		}

		// 周期
		sb.append(" and duration > ").append(criteria.getPeriod().getMin());
		if (criteria.getPeriod().getMax() > 0) {
			sb.append(" and duration < ").append(
					criteria.getPeriod().getMax());
		}

		if (criteria.getPlatform() > -1) {
			sb.append(" and sourcesiteid = ").append(criteria.getPlatform());
		}

		if (criteria.getOderBy() != null) {
			sb.append(" order by ").append(criteria.getOderBy().toString())
					.append(" ").append(criteria.getOrderType());
		}

		return sb.toString();
	}
}
