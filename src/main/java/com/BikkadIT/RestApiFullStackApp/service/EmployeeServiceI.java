package com.BikkadIT.RestApiFullStackApp.service;

import java.util.List;

import com.BikkadIT.RestApiFullStackApp.entities.Employee;

public interface EmployeeServiceI {

	public Employee addEmployee(Employee emp);
	public List<Employee> addAllemployee(List<Employee> emp);
	public Employee getbyID (int empid);
	public List<Employee> getAllEmployee();
	public List<Employee> byage(int age);
	public Employee updateEmployee(Employee emp);
	public List<Employee> UpdateMultiple(List<Employee> list);
	public boolean loginCheck(int empId,String empEmail);
	public boolean deleteByEMPID(int id);
	public boolean deleteAll();
}
