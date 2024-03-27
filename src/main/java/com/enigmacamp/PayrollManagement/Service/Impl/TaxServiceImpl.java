package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.Tax;
import com.enigmacamp.PayrollManagement.Repository.TaxRepository;
import com.enigmacamp.PayrollManagement.Service.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaxServiceImpl implements TaxService {
    private final TaxRepository taxRepository;

    @Override
    public Tax saveTax(Tax tax) {
        return taxRepository.save(tax);
    }

    @Override
    public List<Tax> getAllTax() {
        return taxRepository.findAll();
    }
}
