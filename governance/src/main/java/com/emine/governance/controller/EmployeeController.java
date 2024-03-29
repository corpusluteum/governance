package com.emine.governance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.emine.governance.models.Employee;
import com.emine.governance.service.EmployeeServices;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServices employeeService;
	
	 EmployeeController(EmployeeServices employeeServices) {
          this.employeeService = employeeServices;
     }
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		Employee employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = employeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee, UriComponentsBuilder builder) {
                boolean flag = employeeService.addEmployee(employee);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/employee/{id}").buildAndExpand(employee.getEmployeeId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("/")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}
