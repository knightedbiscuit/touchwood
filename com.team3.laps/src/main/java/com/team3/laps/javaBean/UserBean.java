package com.team3.laps.javaBean;

import com.team3.laps.model.Employee;
import com.team3.laps.model.Role;

public class UserBean {

	private Employee user;//set this via some controller.
	private String userName;//user.getName();
	private int userId;//user.getEmployeeId();
	private String password;//user.getPassword();
	private Role role;//set this via some controller.
	private Employee manager;
	
    public Employee getUser() {
		return user;
	}
	public void setUser(Employee user) {
		this.user = user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public UserBean(){
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBean other = (UserBean) obj;
		if (userId!=(other.getUserId()))
			return false;		
		else return true;

	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + ", role=" + role + ", manager=" + manager
				+ "]";
	}
	
}
