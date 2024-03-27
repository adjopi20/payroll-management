package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.Department;
import com.enigmacamp.PayrollManagement.Entity.Employee;
import com.enigmacamp.PayrollManagement.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody String stringEDepartment){
        Department savedDepartment = departmentService.saveDepartment(stringEDepartment);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> departments = departmentService.getAllDepartment();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
}
