package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.Salary;
import com.enigmacamp.PayrollManagement.Repository.SalaryRepository;
import com.enigmacamp.PayrollManagement.Service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {
    private final SalaryRepository salaryRepository;
    @Override
    public Salary saveSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public List<Salary> getAllSalary() {
        return salaryRepository.findAll();
    }
}
