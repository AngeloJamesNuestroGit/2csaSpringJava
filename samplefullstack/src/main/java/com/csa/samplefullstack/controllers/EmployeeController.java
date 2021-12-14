package com.csa.samplefullstack.controllers;

import com.csa.samplefullstack.entity.Employee;
import com.csa.samplefullstack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired 
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();

    }

    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    
    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeFromId(@PathVariable Long employeeId){
        return employeeRepository.findById(employeeId).get();
    }
    
    @PutMapping("/employee")
    public Employee putEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long employeeId){
        employeeRepository.deleteById(employeeId);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
