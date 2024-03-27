package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.PaymentDetail;
import com.enigmacamp.PayrollManagement.Service.PaymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction-payment")
@RequiredArgsConstructor
public class PaymentDetailController {
    private final PaymentDetailService paymentDetailService;

    @PostMapping
    public ResponseEntity<PaymentDetail> savedTransactionPayment(@RequestBody PaymentDetail paymentDetail){
        PaymentDetail savedPaymentDetail = paymentDetailService.saveTransactionPayment(paymentDetail);
        return new ResponseEntity<>(savedPaymentDetail, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PaymentDetail>> getAllTransactionPayment(){
        List<PaymentDetail> paymentDetails = paymentDetailService.getTransactionPayment();
        return new ResponseEntity<>(paymentDetails, HttpStatus.OK);
    }

}
