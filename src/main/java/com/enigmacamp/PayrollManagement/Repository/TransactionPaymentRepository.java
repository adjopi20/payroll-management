package com.enigmacamp.PayrollManagement.Repository;

import com.enigmacamp.PayrollManagement.Entity.TransactionPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionPaymentRepository extends JpaRepository<TransactionPayment, String> {

    @Query(value = "SELECT SUM(amount) FROM transaction_payment", nativeQuery = true)
    TransactionPayment getTotalToBePaid();
}
