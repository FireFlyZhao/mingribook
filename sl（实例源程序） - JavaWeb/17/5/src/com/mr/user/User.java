package com.mr.user;

import java.util.Set;

import com.mr.role.Role;

public class User {

	private Integer id;//Ψһ�Ա�ʶ
	private String name;//�û�����
	private Set<Role> roles;//���õ�Ȩ��ʵ����󼯺�

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
