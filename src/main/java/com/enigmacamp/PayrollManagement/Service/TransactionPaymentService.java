package com.enigmacamp.PayrollManagement.Service;

import com.enigmacamp.PayrollManagement.Entity.Employee;
import com.enigmacamp.PayrollManagement.Entity.TransactionPayment;

import java.util.List;

public interface TransactionPaymentService {
    TransactionPayment saveTransactionPayment(TransactionPayment transactionPayment);
    List<TransactionPayment> getTransactionPayment();
}
