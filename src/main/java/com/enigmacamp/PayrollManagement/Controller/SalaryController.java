package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.Salary;
import com.enigmacamp.PayrollManagement.Service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salary")
@RequiredArgsConstructor
public class SalaryController {
    private final SalaryService salaryService;

    @PostMapping
    public ResponseEntity<Salary> saveSalary (Salary salary){
        Salary savedSalary = salaryService.saveSalary(salary);
        return new ResponseEntity<>(savedSalary, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Salary>> getAllSalary(){
        List<Salary> salaries = salaryService.getAllSalary();
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }
}
