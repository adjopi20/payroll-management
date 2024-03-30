package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.ToBePaid;
import com.enigmacamp.PayrollManagement.Repository.ToBePaidRepository;
import com.enigmacamp.PayrollManagement.Service.ToBePaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToBePaidServiceImpl implements ToBePaidService {
    private final ToBePaidRepository toBePaidRepository;
    @Override
    public ToBePaid saveTransactionPayment(ToBePaid toBePaid) {
        return toBePaidRepository.save(toBePaid);
    }

    @Override
    public List<ToBePaid> getTransactionPayment() {
        return toBePaidRepository.findAll();
    }

    @Override
    public Optional<ToBePaid> getPaymentDetailById(Long id) {
        return toBePaidRepository.getPaymentDetailById(id);
    }

    @Override
    public List<ToBePaid> getAmountToBePaidForEachEmployee() {
        return toBePaidRepository.getAmountToBePaidForEachEmployee();
    }
}
