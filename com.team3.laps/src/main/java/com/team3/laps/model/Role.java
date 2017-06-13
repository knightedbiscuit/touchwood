package com.team3.laps.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@Column(name="id")
	private Integer roleId;
	
	@Column(name="description")
	private String description;
	
	/** Container for Roles **/

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Role(Integer role_id, String Description) {
		super();
		roleId = role_id;
		description = Description;
	}

	@Override
	public String toString() {
		return "Role [description=" + description + "]";
	}
	
}
