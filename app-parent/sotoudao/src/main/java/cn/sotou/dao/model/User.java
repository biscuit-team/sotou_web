package cn.sotou.dao.model;

// Generated Feb 26, 2014 10:37:32 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "sotou")
public class User implements java.io.Serializable {

	private Integer uid;
	private String email;
	private String phone;
	private String username;
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<LoginInfo> logininfos = new HashSet<LoginInfo>(0);

	public User() {
	}

	public User(String email, String username) {
		this.email = email;
		this.username = username;
	}

	public User(String email, String phone, String username,
			Set<Comment> comments, Set<LoginInfo> logininfos) {
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.comments = comments;
		this.logininfos = logininfos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "uid", unique = true, nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "email", nullable = false, length = 32)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 16)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "username", nullable = false, length = 32)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<LoginInfo> getLogininfos() {
		return this.logininfos;
	}

	public void setLogininfos(Set<LoginInfo> logininfos) {
		this.logininfos = logininfos;
	}

}
