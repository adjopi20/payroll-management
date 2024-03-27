package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.Employee;
import com.enigmacamp.PayrollManagement.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(Employee employee){
        Employee savedEmployees = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
