package com.mr.user;

import java.util.Set;

import com.mr.role.Role;

public class User {

	private Integer id;//唯一性标识
	private String name;//用户名称
	private Set<Role> roles;//引用的权限实体对象集合

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
