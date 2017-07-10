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

import com.emine.governance.models.Department;
import com.emine.governance.service.DepartmentServices;
import com.emine.governance.service.EmployeeServices;


@RestController
@RequestMapping("department")
public class DepartmentController {
	
	@Autowired
	private DepartmentServices departmentService;
	
	DepartmentController(DepartmentServices departmentServices) {
         this.departmentService = departmentServices;
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Integer id) {
		Department department = departmentService.getDepartmentById(id);
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> list = departmentService.getAllDepartment();
		return new ResponseEntity<List<Department>>(list, HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<Void> addDepartment(@RequestBody Department department, UriComponentsBuilder builder) {
                boolean flag = departmentService.addDepartment(department);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/department/{id}").buildAndExpand(department.getDepartmentId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("/")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		departmentService.updateDepartment(department);
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable("id") Integer id) {
		departmentService.deleteDepartment(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}

