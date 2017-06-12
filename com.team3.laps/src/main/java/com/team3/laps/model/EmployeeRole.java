package com.team3.laps.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee-role")
@IdClass(EmployeeRole.class)
public class EmployeeRole implements Serializable {
	
//	@Id
//	@Column(name="employee_id")
//	private int employeeId;
//	
//	@Id
//	@Column(name="role_id")
//	private int roleId;
	
	@Id
	@OneToOne(targetEntity = Role.class,cascade=CascadeType.ALL)
	@JoinColumn(name="role_id",referencedColumnName="id")
	private Role role;
	
	@Id
	@OneToOne(targetEntity = Employee.class,cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id",referencedColumnName="id")
    private Employee emp;
	
	//@OneToOne (mappedBy="employee-role", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//private Role role= new Role();
	
	/*Don't think this mapping is needed, which is why it is commented out
	 * 
	 * @ManyToOne (cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Employee employee= new Employee();*/

//	public int getEmployeeId() {
//		return employeeId;
//	}
//
//	public void setEmployeeId(int employeeId) {
//		this.employeeId = employeeId;
//	}
//
//	public int getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	
	//public String getRole() {
	//	return getRole();
	//}

	/*public void setRole(String role) {
		Role = role;
	}*/

	public EmployeeRole(Employee e, Role r) {
		super();
		emp = e;
		role = r;
		//Role_id = role;
	}

	public EmployeeRole() {
		// TODO Auto-generated constructor stub
	}
}
