package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.TransactionPayment;
import com.enigmacamp.PayrollManagement.Repository.TransactionPaymentRepository;
import com.enigmacamp.PayrollManagement.Service.TransactionPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionPaymentServiceImpl implements TransactionPaymentService {
    private final TransactionPaymentRepository transactionPaymentRepository;
    @Override
    public TransactionPayment saveTransactionPayment(TransactionPayment transactionPayment) {
        return transactionPaymentRepository.save(transactionPayment);
    }

    @Override
    public List<TransactionPayment> getTransactionPayment() {
        return transactionPaymentRepository.findAll();
    }
}
