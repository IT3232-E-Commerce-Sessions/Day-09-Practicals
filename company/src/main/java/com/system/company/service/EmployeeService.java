package com.system.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.system.company.model.Employee;
import com.system.company.repo.EmployeeRepo;

public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;
	
	public List<Employee> getEmploys(){
		return repo.findAll();
	}
	
	public Employee getEmploy(@PathVariable("empNo") String empNo) {
		return repo.findById(empNo).get();
	}
	
	public Employee addEmploy(Employee employee) {
		return repo.save(employee);
	}
	
	public Employee updateEmploy(String empNo, Employee updatedEmployee) {
        return repo.findById(empNo)
                .map(existing -> {
                    existing.setName(updatedEmployee.getName());
                    existing.setAge(updatedEmployee.getAge());
                    existing.setSalary(updatedEmployee.getSalary());
                    existing.setGender(updatedEmployee.getGender());
                    
                    if(updatedEmployee.getDepartment() != null) {
                        existing.setDepartment(updatedEmployee.getDepartment());
                    }
                    return repo.save(existing);
                })
                .orElse(null);
    }

    public boolean deleteEmploy(String empNo) {
        if(repo.existsById(empNo)) {
            repo.deleteById(empNo);
            return true;
        }
        return false;
    }

	
	

}
