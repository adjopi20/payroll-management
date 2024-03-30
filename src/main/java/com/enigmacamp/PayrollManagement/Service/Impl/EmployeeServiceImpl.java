package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.Employee;
import com.enigmacamp.PayrollManagement.Repository.EmployeeRepository;
import com.enigmacamp.PayrollManagement.Service.EmployeeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return  employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> getEmployeeById2(Long id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> findEmployeeByDeptid(Long id) {
        return employeeRepository.findByDepartmentId(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findMarketingStaff() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .filter(employee -> "MARKETING".equals(employee.getDepartment().getName()))
                .filter(employee -> "STAFF".equals(employee.getPosition().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findEmployeesWithMoreThan5YearsOfService() {
        LocalDate currentDate = LocalDate.now();

        return employeeRepository.findAll().stream()
                .filter(employee -> {
                    LocalDate hireDate = employee.getHireDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    long yearsOfService = ChronoUnit.YEARS.between(hireDate, currentDate);
                    return yearsOfService > 5;
                })
                .collect(Collectors.toList());
    }


}
