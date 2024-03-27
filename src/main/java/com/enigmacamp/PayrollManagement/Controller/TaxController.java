package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.Tax;
import com.enigmacamp.PayrollManagement.Service.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tax")
@RequiredArgsConstructor
public class TaxController {
    private final TaxService taxService;

    @PostMapping
    public ResponseEntity<Tax> savedTax(@RequestBody Tax tax){
        Tax savedTax = taxService.saveTax(tax);
        return new ResponseEntity<>(savedTax, HttpStatus.CREATED);
    }

    @RequestMapping
    public ResponseEntity<List<Tax>> getAllTax(){
        List<Tax> taxes = taxService.getAllTax();
        return new ResponseEntity<>(taxes, HttpStatus.OK);
    }

}
