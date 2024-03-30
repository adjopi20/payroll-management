package com.enigmacamp.PayrollManagement.Repository;

import com.enigmacamp.PayrollManagement.Entity.MonthlyPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonthlyPaymentRepository extends JpaRepository<MonthlyPayment, Long> {
    @Query(value = "SELECT mp.id, mp.payment_date, mp.status, mp.tbpd_id, e.name " +
            "FROM monthly_payment mp " +
            "LEFT JOIN tobepaid_detail tbpd ON mp.tbpd_id=tbpd.id " +
            "LEFT JOIN m_employee e ON tbpd.employee_id=e.id " +
            "WHERE status='UNPAID'", nativeQuery = true)
    List<MonthlyPayment> getEmployeeThatHasNotBeenPaid();
}
