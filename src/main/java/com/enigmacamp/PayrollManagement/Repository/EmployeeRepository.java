package com.enigmacamp.PayrollManagement.Repository;

import com.enigmacamp.PayrollManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value= "SELECT * FROM m_employee WHERE department_id = ?", nativeQuery = true)
    List<Employee> findByDepartmentId(Long departmentId);

    @Query(value= "SELECT * FROM m_employee WHERE id = ?1", nativeQuery = true)
    Optional<Employee> getEmployeeById(Long employeeId);
}