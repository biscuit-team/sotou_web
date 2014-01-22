package cn.sotou.dao.model;

// Generated Jan 22, 2014 4:42:30 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SiteInfo generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "site_info", catalog = "dbtest")
public class SiteInfo implements java.io.Serializable {

	private Integer id;
	private String sourcesiteen;
	private String sourcesitecn;

	public SiteInfo() {
	}

	public SiteInfo(String sourcesiteen, String sourcesitecn) {
		this.sourcesiteen = sourcesiteen;
		this.sourcesitecn = sourcesitecn;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "sourcesiteen", nullable = false, length = 512)
	public String getSourcesiteen() {
		return this.sourcesiteen;
	}

	public void setSourcesiteen(String sourcesiteen) {
		this.sourcesiteen = sourcesiteen;
	}

	@Column(name = "sourcesitecn", nullable = false, length = 512)
	public String getSourcesitecn() {
		return this.sourcesitecn;
	}

	public void setSourcesitecn(String sourcesitecn) {
		this.sourcesitecn = sourcesitecn;
	}

}
