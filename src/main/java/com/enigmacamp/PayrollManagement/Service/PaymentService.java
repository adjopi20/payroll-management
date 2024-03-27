package com.enigmacamp.PayrollManagement.Service;

import com.enigmacamp.PayrollManagement.Entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment savePayment(String statusPayment);
    List<Payment> getAll();
}
