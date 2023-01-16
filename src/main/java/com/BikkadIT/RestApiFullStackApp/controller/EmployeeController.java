package com.BikkadIT.RestApiFullStackApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.RestApiFullStackApp.entities.Employee;
import com.BikkadIT.RestApiFullStackApp.service.EmployeeServiceI;


@RestController
public class EmployeeController {
@Autowired
	private EmployeeServiceI employeeServiceI;
	
@PostMapping(value="addEmployee",consumes= {"application/json","application/xml"},produces={"application/json","application/xml"})
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
	{
		Employee addEmployee = employeeServiceI.addEmployee(emp);
		
		return new ResponseEntity<Employee> (addEmployee,HttpStatus.CREATED);
		
	}

@PostMapping(value="addAllEmployee",consumes= {"application/json","application/xml"},produces={"application/json","application/xml"})
public ResponseEntity<List<Employee>> addAllEmployee(@RequestBody List<Employee> emp)
{
List<Employee> addAllemployee = employeeServiceI.addAllemployee(emp);
	
	return new ResponseEntity<List<Employee>>(addAllemployee,HttpStatus.CREATED);
	
}



@GetMapping(value="getByID/{empid}",produces={"application/json","application/xml"})
public ResponseEntity<Employee> getByID(@PathVariable int empid)
{
 Employee getbyID = employeeServiceI.getbyID(empid);
	
	return new ResponseEntity<Employee>(getbyID,HttpStatus.OK) ;
	
}

@GetMapping(value="getAllEmployee",produces={"application/json","application/xml"})
public ResponseEntity<List<Employee>> getAllEmployee()
{
  List<Employee> allEmployee = employeeServiceI.getAllEmployee();
	return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK) ;
	
}


@GetMapping(value="getByAge/{age}",produces={"application/json","application/xml"})
public ResponseEntity<List<Employee>> getByAge(@PathVariable int age)
{
  List<Employee> byage = employeeServiceI.byage(age);
	return new ResponseEntity<List<Employee>>(byage,HttpStatus.OK) ;
	
}


@PutMapping(value="updateEmployee",consumes= {"application/json","application/xml"},produces={"application/json","application/xml"})
public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp)
{
  Employee updateEmployee = employeeServiceI.updateEmployee(emp);
	return new ResponseEntity<Employee>(updateEmployee,HttpStatus.CREATED) ;
	
}

@PutMapping(value="updateMultipleEmployee",consumes= {"application/json","application/xml"},produces={"application/json","application/xml"})
public ResponseEntity<List<Employee>> updateMultipleEmployee(@RequestBody List< Employee> list)
{
  List<Employee> updateMultiple = employeeServiceI.UpdateMultiple(list);
	return new ResponseEntity<List<Employee>>(updateMultiple,HttpStatus.CREATED) ;
	
}


@GetMapping(value="loginCheck/{id}/{email}",produces={"application/json","application/xml"})
public ResponseEntity<String> loginCheck(@PathVariable int id,@PathVariable String email)
{
   boolean loginCheck = employeeServiceI.loginCheck(id, email);
   
   if(loginCheck)
   {
	   String msg="login successful";
	return new ResponseEntity<String>(msg,HttpStatus.OK) ;
   }
   
   else
   {
	   String msg1="login unsuccessful";
	   return new ResponseEntity<String>(msg1,HttpStatus.OK) ;
   }
   
 
}

@DeleteMapping(value="/deleteByID/{id}")
public String deleteByEMPID(@PathVariable int id)
{
	   boolean deleteByEMPID2 = employeeServiceI.deleteByEMPID(id);
	   if(deleteByEMPID2)
	   {
		   String msg="deleted successfully";
		   return msg;
	   }
	 String msg1="id not found";
	return msg1;
}

@DeleteMapping(value="/deleteAll")
public String deleteAll()
{
	   boolean deleteAll = employeeServiceI.deleteAll();
	   if(deleteAll)
	   {
		   String msg="deleted successfully";
		   return msg;
	   }
	 String msg1="not deleted";
	return msg1;
}


















}

