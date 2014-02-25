package cn.sotou.dao.model;

// Generated 2014-2-25 20:47:37 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InvestItemId generated by hbm2java
 */
@Embeddable
public class InvestItemId implements java.io.Serializable {

	private String loanid;
	private String sourcesiteen;
	private int projecttype;

	public InvestItemId() {
	}

	public InvestItemId(String loanid, String sourcesiteen, int projecttype) {
		this.loanid = loanid;
		this.sourcesiteen = sourcesiteen;
		this.projecttype = projecttype;
	}

	@Column(name = "loanid", nullable = false, length = 128)
	public String getLoanid() {
		return this.loanid;
	}

	public void setLoanid(String loanid) {
		this.loanid = loanid;
	}

	@Column(name = "sourcesiteen", nullable = false, length = 64)
	public String getSourcesiteen() {
		return this.sourcesiteen;
	}

	public void setSourcesiteen(String sourcesiteen) {
		this.sourcesiteen = sourcesiteen;
	}

	@Column(name = "projecttype", nullable = false)
	public int getProjecttype() {
		return this.projecttype;
	}

	public void setProjecttype(int projecttype) {
		this.projecttype = projecttype;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InvestItemId))
			return false;
		InvestItemId castOther = (InvestItemId) other;

		return ((this.getLoanid() == castOther.getLoanid()) || (this
				.getLoanid() != null && castOther.getLoanid() != null && this
				.getLoanid().equals(castOther.getLoanid())))
				&& ((this.getSourcesiteen() == castOther.getSourcesiteen()) || (this
						.getSourcesiteen() != null
						&& castOther.getSourcesiteen() != null && this
						.getSourcesiteen().equals(castOther.getSourcesiteen())))
				&& (this.getProjecttype() == castOther.getProjecttype());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLoanid() == null ? 0 : this.getLoanid().hashCode());
		result = 37
				* result
				+ (getSourcesiteen() == null ? 0 : this.getSourcesiteen()
						.hashCode());
		result = 37 * result + this.getProjecttype();
		return result;
	}

}
