package com.system.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.company.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
