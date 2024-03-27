package com.enigmacamp.PayrollManagement.Service;

import com.enigmacamp.PayrollManagement.Entity.Department;
import com.enigmacamp.PayrollManagement.Entity.Employee;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartment();
}
