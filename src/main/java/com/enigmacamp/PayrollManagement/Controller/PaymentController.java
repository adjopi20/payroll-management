package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.Payment;
import com.enigmacamp.PayrollManagement.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping
    public ResponseEntity<Payment> savePayment(@RequestBody String status){
        Payment payment = paymentService.savePayment(status);
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayment(){
        List<Payment> payments = paymentService.getAll();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

}
