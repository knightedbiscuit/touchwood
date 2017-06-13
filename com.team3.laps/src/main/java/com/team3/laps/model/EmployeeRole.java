package com.team3.laps.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee-role")
public class EmployeeRole {
	
	@Id
	@Column(name="pk_id")
	private Integer pkId;
	
//	@Column(name="employee_id",insertable=false ,updatable=false)
//	private Integer employeeId;
//	
//	
//	@Column(name="role_id",insertable=false ,updatable=false)
//	private Integer roleId;
	
	@OneToOne(targetEntity = Role.class,cascade=CascadeType.ALL)
	@JoinColumn(name="role_id",referencedColumnName="id")
	private Role role;
	
	@OneToOne(targetEntity = Employee.class,mappedBy="empRole",cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id",referencedColumnName="id")
    private Employee emp;
	
	//@OneToOne (mappedBy="employee-role", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//private Role role= new Role();
	
	/*Don't think this mapping is needed, which is why it is commented out
	 * 
	 * @ManyToOne (cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Employee employee= new Employee();*/

	public Integer getEmployeeId() {
		return emp.getEmployeeId();
	}

//	public void setEmployeeId(Integer employeeId) {
//		this.employeeId = employeeId;
//	}

	public Integer getRoleId() {
		return role.getRoleId();
	}

//	public void setRoleId(Integer roleId) {
//		this.roleId = roleId;
//	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
		this.role.setRoleId(role.getRoleId());
	}

	public Employee getEmp() {
		return emp;
	}

//	public void setEmp(Employee emp) {
//		this.emp = emp;
//	}

	public Integer getemployeeId() {
		return emp.getEmployeeId();
	}

//	public void setEmployeeid(Integer employeeid) {
//		employeeId = employeeid;
//	}

	public Integer getroleId() {
		return role.getRoleId();
	}

//	public void setroleId(Integer role_id) {
//		roleId = role_id;
//	}

	//public String getRole() {
	//	return getRole();
	//}

	/*public void setRole(String role) {
		Role = role;
	}*/


	public EmployeeRole() {
		// TODO Auto-generated constructor stub
	}
}
