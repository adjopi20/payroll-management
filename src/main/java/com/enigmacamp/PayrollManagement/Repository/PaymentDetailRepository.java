package com.enigmacamp.PayrollManagement.Repository;

import com.enigmacamp.PayrollManagement.Entity.Employee;
import com.enigmacamp.PayrollManagement.Entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, String> {

//    @Query(value = "SELECT SUM(amount) FROM transaction_payment", nativeQuery = true)
//    PaymentDetail getTotalToBePaid();
@Query(value= "SELECT * FROM m_employee WHERE employee_id = ?1", nativeQuery = true)
Optional<PaymentDetail> getPaymentDetailById(Long id);
}
