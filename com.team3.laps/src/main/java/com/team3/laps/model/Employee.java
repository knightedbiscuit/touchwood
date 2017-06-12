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
import javax.persistence.Table;

@Entity
@Table(name="employee")

public class Employee {
	@Id
	@Column(name="id")
	private int employeeId;

	@Column(name="name", nullable= false)
	private String name;

	@Column(name="email", nullable= false)
	private String email;

//	@Column(name="manager_id")
//	private String managerId;
//	
	@Column(name="password")
	private String password;
	
	@OneToMany(targetEntity=Compensation.class, mappedBy="emp",cascade=javax.persistence.CascadeType.ALL)
	private List<Compensation> compensations = new ArrayList<Compensation>();
	
	@ManyToOne(targetEntity = Employee.class, cascade=CascadeType.ALL)
	private Employee manager;
	
	@OneToMany(targetEntity=Employee.class,mappedBy="manager",cascade=javax.persistence.CascadeType.ALL)
    //@JoinColumn(name="manager_id",referencedColumnName="id")
	private List<Employee> subordinates = new ArrayList<Employee>();
	
	@OneToMany(targetEntity=Leave.class,mappedBy="emp", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Leave> employeeLeaves= new ArrayList<Leave>();
	
	@ManyToOne(targetEntity = Role.class,cascade=CascadeType.ALL)
	private Role role;
	
	public List<Compensation> getCompensations() {
		return compensations;
	}

	public void setCompensations(ArrayList<Compensation> compensations) {
		this.compensations = compensations;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(ArrayList<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	public List<Leave> getEmployeeLeaves() {
		return employeeLeaves;
	}

	public void setEmployeeLeaves(ArrayList<Leave> employeeLeaves) {
		this.employeeLeaves = employeeLeaves;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getManagerId() {
//		return managerId;
//	}
//
//	public void setManagerId(String managerId) {
//		this.managerId = managerId;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//public Role getCurrentrole() {
	//	return currentRole;
	//}

	//public void setCurrentrole(Role currentRole) {
	//	this.currentRole = currentRole;
	//}

	/*public List<EmployeeLeaveTracker> getemployeeLeaves() {
		return employeeLeaves;
	}

	public void setemployeeLeaves(List<EmployeeLeaveTracker> employee_leaves) {
		employeeLeaves = employee_leaves;
	}*/

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String Name, String Email, Employee m, String Password) {
		super();
		employeeId = id;
		name = Name;
		email = Email;
		manager = m;
		password = Password;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + "]";
	}
	


}
