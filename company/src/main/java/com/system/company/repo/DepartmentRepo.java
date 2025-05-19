package com.system.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.company.model.Department;


@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
