package com.enigmacamp.PayrollManagement.Service;

import com.enigmacamp.PayrollManagement.Entity.ToBePaid;

import java.util.List;
import java.util.Optional;

public interface ToBePaidService {
    ToBePaid saveTransactionPayment(ToBePaid toBePaid);
    List<ToBePaid> getTransactionPayment();
    Optional<ToBePaid> getPaymentDetailById(Long id);
    List<ToBePaid> getAmountToBePaidForEachEmployee();
}
