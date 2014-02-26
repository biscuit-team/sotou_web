package cn.sotou.dao.model;

// Generated Jan 23, 2014 2:53:45 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * StakeType generated by hbm2java
 */
@Entity
@Table(name = "stake_type", catalog = "sotou")
public class StakeType implements java.io.Serializable {

	private Integer id;
	private String type;

	public StakeType() {
	}

	public StakeType(String type) {
		this.type = type;
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

	@Column(name = "type", nullable = false, length = 512)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}