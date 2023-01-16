package com.BikkadIT.RestApiFullStackApp.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.RestApiFullStackApp.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Serializable>{

	public List<Employee> findByEmpAgeLessThan(int age);
	public Employee findByEmpIdAndEmpEmail(int id,String email);
}
