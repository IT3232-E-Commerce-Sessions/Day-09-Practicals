package com.system.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.system.company.model.Employee;
import com.system.company.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getEmploys());
    }

    @GetMapping("/{empNo}")
    public ResponseEntity<?> getEmployee(@PathVariable String empNo) {
        Employee employee = employeeService.getEmploy(empNo);
        return employee != null ? 
            ResponseEntity.ok(employee) : 
            ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmploy(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping("/{empNo}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String empNo,
            @RequestBody Employee employeeDetails) {
        
        Employee updated = employeeService.updateEmploy(empNo, employeeDetails);
        return updated != null ?
            ResponseEntity.ok(updated) :
            ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{empNo}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String empNo) {
        return employeeService.deleteEmploy(empNo) ?
            ResponseEntity.ok().build() :
            ResponseEntity.notFound().build();
    }
}