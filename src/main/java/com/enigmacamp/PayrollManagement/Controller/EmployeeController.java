package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.Employee;
import com.enigmacamp.PayrollManagement.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(savedEmployee);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/tes2/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id){
        Optional<Employee> employees = employeeService.getEmployeeById2(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find-by-department/{id}")
    public ResponseEntity<List<Employee>> getAllEmployeesByDepartmentId(@PathVariable Long id){
        List<Employee> employees = employeeService.findEmployeeByDeptid(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/marketing-staff")
    public ResponseEntity<List<Employee>> getMarketingStaff(){
        List<Employee> employees = employeeService.findMarketingStaff();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/more-than-5")
    public ResponseEntity<List<Employee>> findEmployeesWithMoreThan5YearsOfService(){
        List<Employee> employees = employeeService.findEmployeesWithMoreThan5YearsOfService();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
