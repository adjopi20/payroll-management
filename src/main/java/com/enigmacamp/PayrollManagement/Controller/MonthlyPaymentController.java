package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.MonthlyPayment;
import com.enigmacamp.PayrollManagement.Service.MonthlyPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class MonthlyPaymentController {
    private final MonthlyPaymentService monthlyPaymentService;
    @PostMapping
    public ResponseEntity<MonthlyPayment> savePayment(@RequestBody String status){
        MonthlyPayment monthlyPayment = monthlyPaymentService.savePayment(status);
        return new ResponseEntity<>(monthlyPayment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MonthlyPayment>> getAllPayment(){
        List<MonthlyPayment> monthlyPayments = monthlyPaymentService.getAll();
        return new ResponseEntity<>(monthlyPayments, HttpStatus.OK);
    }

    @GetMapping("/unpaid")
    public ResponseEntity<List<MonthlyPayment>> getUnpaidPayment(){
        List<MonthlyPayment> monthlyPayments = monthlyPaymentService.getEmployeeThatHasNotBeenPaid();
        return new ResponseEntity<>(monthlyPayments, HttpStatus.OK);
    }

}
