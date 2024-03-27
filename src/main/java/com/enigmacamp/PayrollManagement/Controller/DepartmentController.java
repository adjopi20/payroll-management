package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.Department;
import com.enigmacamp.PayrollManagement.Entity.Employee;
import com.enigmacamp.PayrollManagement.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<Department> saveDepartment(Department department){
        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> departments = departmentService.getAllDepartment();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
}
