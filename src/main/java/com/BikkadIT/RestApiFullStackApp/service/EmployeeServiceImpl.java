package com.BikkadIT.RestApiFullStackApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.RestApiFullStackApp.entities.Employee;
import com.BikkadIT.RestApiFullStackApp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {
@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee emp) {
		Employee save = employeeRepository.save(emp);
		return save;
	}

	@Override
	public List<Employee> addAllemployee(List<Employee> emp) {
		List<Employee> saveAll = employeeRepository.saveAll(emp);
		return saveAll;
	}

	@Override
	public Employee getbyID(int empid) {
		Employee employee = employeeRepository.findById(empid).get();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();
		return findAll;
	}

	@Override
	public List<Employee> byage(int age) {
		 List<Employee> findByEmpAgeLessThan = employeeRepository.findByEmpAgeLessThan(age);
		return findByEmpAgeLessThan;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee save = employeeRepository.save(emp);
		return save;
	}

	@Override
	public List<Employee> UpdateMultiple(List<Employee> list) {
		List<Employee> saveAll = employeeRepository.saveAll(list);
		return saveAll;
	}

	@Override
	public boolean loginCheck(int empId, String empEmail) {
		Employee findByEmpIdAndEmpEmail = employeeRepository.findByEmpIdAndEmpEmail(empId, empEmail);
		
		if(findByEmpIdAndEmpEmail !=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteByEMPID(int id) {
		  boolean existsById = employeeRepository.existsById(id);
		
		if(existsById)
		{
			employeeRepository.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
		

	}

	@Override
	public boolean deleteAll() {
		employeeRepository.deleteAll();
		return true;
	}

	


}

