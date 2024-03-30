package com.enigmacamp.PayrollManagement.Repository;

import com.enigmacamp.PayrollManagement.Entity.MonthlyPayment;
import com.enigmacamp.PayrollManagement.Entity.ToBePaid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToBePaidRepository extends JpaRepository<ToBePaid, String> {
    @Query(value= "SELECT * FROM tobepaid_detail WHERE id = ?1", nativeQuery = true)
    Optional<ToBePaid> getPaymentDetailById(Long id);

    @Query(value = "SELECT tbpd.id, tbpd.employee_id, tbpd.bonus, tbpd.penalty, s.allowance, s.basic_salary, t.tax_percentage, " +
            "CAST((s.basic_salary * (1 - t.tax_percentage / 100)) + s.allowance + tbpd.bonus - tbpd.penalty AS INTEGER) AS net_salary " +
            "FROM tobepaid_detail tbpd " +
            "LEFT JOIN m_employee e ON tbpd.employee_id=e.id " +
            "LEFT JOIN tax t ON e.tax_id=t.id " +
            "LEFT JOIN salary s ON s.id=e.salary_id ", nativeQuery = true)
    List<ToBePaid> getAmountToBePaidForEachEmployee();
}

