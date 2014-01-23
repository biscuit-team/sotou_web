package cn.sotou.dao.model;

// Generated Jan 23, 2014 2:53:45 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ListOld generated by hbm2java
 */
@Entity
@Table(name = "list_old", catalog = "sotou")
public class ListOld implements java.io.Serializable {

	private ListOldId id;

	public ListOld() {
	}

	public ListOld(ListOldId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "sourcesiteen", column = @Column(name = "sourcesiteen", nullable = false, length = 64)),
			@AttributeOverride(name = "sourcesitecn", column = @Column(name = "sourcesitecn", nullable = false, length = 64)),
			@AttributeOverride(name = "url", column = @Column(name = "url", nullable = false, length = 512)),
			@AttributeOverride(name = "reachurl", column = @Column(name = "reachurl", nullable = false, length = 512)),
			@AttributeOverride(name = "projecttype", column = @Column(name = "projecttype", nullable = false, length = 512)),
			@AttributeOverride(name = "loanid", column = @Column(name = "loanid", nullable = false, length = 512)) })
	public ListOldId getId() {
		return this.id;
	}

	public void setId(ListOldId id) {
		this.id = id;
	}

}
