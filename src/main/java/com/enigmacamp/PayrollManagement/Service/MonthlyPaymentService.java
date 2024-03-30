package com.enigmacamp.PayrollManagement.Service;

import com.enigmacamp.PayrollManagement.Entity.MonthlyPayment;

import java.util.List;

public interface MonthlyPaymentService {
    MonthlyPayment savePayment(String statusPayment);
    List<MonthlyPayment> getAll();
    List<MonthlyPayment> getEmployeeThatHasNotBeenPaid();
}
