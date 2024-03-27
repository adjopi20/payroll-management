package com.enigmacamp.PayrollManagement.Service;

import com.enigmacamp.PayrollManagement.Entity.PaymentDetail;

import java.util.List;
import java.util.Optional;

public interface PaymentDetailService {
    PaymentDetail saveTransactionPayment(PaymentDetail paymentDetail);
    List<PaymentDetail> getTransactionPayment();
    Optional<PaymentDetail> getPaymentDetailById(Long id);
}
