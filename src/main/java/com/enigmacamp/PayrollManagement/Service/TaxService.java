package com.enigmacamp.PayrollManagement.Service;

import com.enigmacamp.PayrollManagement.Entity.Employee;
import com.enigmacamp.PayrollManagement.Entity.Tax;

import java.util.List;

public interface TaxService {
    Tax saveTax(Tax tax);
    List<Tax> getAllTax();
}
