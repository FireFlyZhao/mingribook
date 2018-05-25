package com.mr.role;

import java.util.Set;

import com.mr.user.User;

public class Role {
	
	private Integer id;//唯一性标识
	
	private String roleName;//权限名称
	
	private Set<User> users;//引用的用户实体对象集合

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
