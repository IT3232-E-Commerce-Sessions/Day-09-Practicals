package com.system.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.system.company.model.Department;
import com.system.company.repo.DepartmentRepo;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo repo;
	
	public List< Department> getDepts(){
		return repo.findAll();
	}
	
	public Department getDept(@PathVariable("id") int id) {
		return repo.findById(id).get();
	}
	
	public Department addDept(Department department) {
		return repo.save(department);
	}
	
	public void deleteDept(int id) {
		repo.deleteById(id);
	}
	
	public Department updateDept(int id, Department updatedDepartment) {
	    Department existingDept = repo.findById(id).orElse(null);
	    if (existingDept != null) {
	        existingDept.setName(updatedDepartment.getName());
	        return repo.save(existingDept);
	    }
	    return null; 
	}
	
}