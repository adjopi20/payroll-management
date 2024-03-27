package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.Department;
import com.enigmacamp.PayrollManagement.Repository.DepartmentRepository;
import com.enigmacamp.PayrollManagement.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
}
