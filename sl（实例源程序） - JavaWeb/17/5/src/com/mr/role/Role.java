package com.mr.role;

import java.util.Set;

import com.mr.user.User;

public class Role {
	
	private Integer id;//Ψһ�Ա�ʶ
	
	private String roleName;//Ȩ������
	
	private Set<User> users;//���õ��û�ʵ����󼯺�

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
