package com.enigmacamp.PayrollManagement.Repository;

import com.enigmacamp.PayrollManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, String> {

    @Query(value= "SELECT * FROM m_employee WHERE department_id = ?", nativeQuery = true)
    List<Employee> findByDepartmentId(String departmentId);
}