package com.enigmacamp.PayrollManagement.Service;

import com.enigmacamp.PayrollManagement.Entity.Employee;
import com.enigmacamp.PayrollManagement.Entity.Salary;

import java.util.List;

public interface SalaryService {
    Salary saveSalary(Salary salary);
    List<Salary> getAllSalary();
}
