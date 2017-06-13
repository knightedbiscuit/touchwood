package com.team3.laps.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")

public class Employee {
	@Id
	@Column(name="id")
	private Integer employeeId;

	@Column(name="name", nullable= false)
	private String name;

	@Column(name="email", nullable= false)
	private String email;

	@Column(name="manager_id",insertable=false,updatable= false)
	private Integer managerId;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(targetEntity=Compensation.class,mappedBy="emp",cascade=CascadeType.ALL)
	private List<Compensation> compensations = new ArrayList<Compensation>();
	
	@ManyToOne(targetEntity = Employee.class, cascade=CascadeType.ALL,optional = true)
	@JoinColumn(name="manager_id",referencedColumnName="id")
	private Employee manager;
	
	@OneToMany(targetEntity=Employee.class,mappedBy="manager",cascade=CascadeType.ALL)
	private List<Employee> subordinates = new ArrayList<Employee>();
	
//	@OneToMany(mappedBy="emp", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	private List<Leave> employeeLeaves= new ArrayList<Leave>();
	
	@OneToOne(targetEntity = EmployeeRole.class,cascade=CascadeType.ALL)
	@JoinColumn(name="id",referencedColumnName="employee_id")
	private EmployeeRole empRole;
	
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
		this.setManagerId(manager.getManagerId());
	}
	private void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public List<Compensation> getCompensations() {
		return compensations;
	}
	public List<Employee> getSubordinates() {
		return subordinates;
	}
//	public List<Leave> getEmployeeLeaves() {
//		return employeeLeaves;
//	}
	public EmployeeRole getEmpRole() {
		return empRole;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String Name, String Email, Integer manager_id, String Password) {
		super();
		employeeId = id;
		name = Name;
		email = Email;
		managerId = manager_id;
		password = Password;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + "]";
	}
	


}
