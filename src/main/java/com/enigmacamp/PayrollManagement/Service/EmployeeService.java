package com.enigmacamp.PayrollManagement.Service;

import com.enigmacamp.PayrollManagement.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Optional<Employee> getEmployeeById(String id);
    Optional<Employee> getEmployeeById2(Long id);
    List<Employee> findEmployeeByDeptid(Long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployee (Long id);
    List<Employee> findMarketingStaff();

}
