package com.system.company.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.company.model.Department;
import com.system.company.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	public DepartmentService service;
	
	@GetMapping
	public ResponseEntity<List<Department>> getDepts(){
		return new ResponseEntity<List<Department>>(service.getDepts(),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDept(@PathVariable("id") int id){
		if(service.getDept(id) == null) {
			return new ResponseEntity<Department>(service.getDept(id),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Department>(service.getDept(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Department> addDept(@RequestBody Department department){
		Department newDepartment= service.addDept(department);
		return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Department> updateDept(
	    @PathVariable("id") int id,
	    @RequestBody Department department
	) {
	    Department updatedDept = service.updateDept(id, department);
	    if (updatedDept == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(updatedDept, HttpStatus.OK);
	}

	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDept(@PathVariable("id") int id) {
        Department department = service.getDept(id);
        if (department == null) {
            return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);
        }
        service.deleteDept(id);
        return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
    }
	

}