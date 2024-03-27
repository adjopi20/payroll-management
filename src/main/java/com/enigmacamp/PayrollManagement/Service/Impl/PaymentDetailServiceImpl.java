package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.PaymentDetail;
import com.enigmacamp.PayrollManagement.Repository.PaymentDetailRepository;
import com.enigmacamp.PayrollManagement.Service.PaymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentDetailServiceImpl implements PaymentDetailService {
    private final PaymentDetailRepository paymentDetailRepository;
    @Override
    public PaymentDetail saveTransactionPayment(PaymentDetail paymentDetail) {
        return paymentDetailRepository.save(paymentDetail);
    }

    @Override
    public List<PaymentDetail> getTransactionPayment() {
        return paymentDetailRepository.findAll();
    }

    @Override
    public Optional<PaymentDetail> getPaymentDetailById(Long id) {
        return paymentDetailRepository.getPaymentDetailById(id);
    }
}
