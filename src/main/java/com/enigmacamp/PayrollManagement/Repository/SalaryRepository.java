package com.enigmacamp.PayrollManagement.Repository;

import com.enigmacamp.PayrollManagement.Entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, String> {
}
