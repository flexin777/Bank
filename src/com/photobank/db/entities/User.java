package com.photobank.db.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String name;
	private Date regDate;
	private Date updateDate;
	private Integer sharing;
	
	@ManyToOne
	@JoinColumn(name="roleId")
	private UserRoleStr userRoleStr;
	
	@OneToMany(mappedBy = "user")
	private Set<Photo> photoes;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    private Password password;
	
	public Integer getuUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getSharing() {
		return sharing;
	}

	public void setSharing(Integer sharing) {
		this.sharing = sharing;
	}

	public UserRoleStr getUserRoleStr() {
		return userRoleStr;
	}

	public void setUserRoleStr(UserRoleStr userRoleStr) {
		this.userRoleStr = userRoleStr;
	}

	public Integer getUserId() {
		return userId;
	}

}
