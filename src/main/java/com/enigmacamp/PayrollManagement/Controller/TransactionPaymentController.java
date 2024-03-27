package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.TransactionPayment;
import com.enigmacamp.PayrollManagement.Service.TransactionPaymentService;
import jakarta.transaction.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction-payment")
@RequiredArgsConstructor
public class TransactionPaymentController {
    private final TransactionPaymentService transactionPaymentService;

    @PostMapping
    public ResponseEntity<TransactionPayment> savedTransactionPayment(TransactionPayment transactionPayment){
        TransactionPayment savedTransactionPayment = transactionPaymentService.saveTransactionPayment(transactionPayment);
        return new ResponseEntity<>(savedTransactionPayment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransactionPayment>> getAllTransactionPayment(){
        List<TransactionPayment> transactionPayments = transactionPaymentService.getTransactionPayment();
        return new ResponseEntity<>(transactionPayments, HttpStatus.OK);
    }

}
