package com.enigmacamp.PayrollManagement.Service;

import com.enigmacamp.PayrollManagement.Entity.Department;
import com.enigmacamp.PayrollManagement.Entity.Employee;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(String stringEDepartment);
    List<Department> getAllDepartment();
}
