package com.tecsup.gestion.model;

public class Role {
	
	String roleId;
	String description;
	public Role(String roleId, String description) {
		super();
		this.roleId = roleId;
		this.description = description;
	}
	
	public Role () {}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}
	
		

}
