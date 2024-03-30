package com.enigmacamp.PayrollManagement.Controller;

import com.enigmacamp.PayrollManagement.Entity.ToBePaid;
import com.enigmacamp.PayrollManagement.Service.ToBePaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tbp-detail")
@RequiredArgsConstructor
public class ToBePaidController {
    private final ToBePaidService toBePaidService;

    @PostMapping
    public ResponseEntity<ToBePaid> savedTransactionPayment(@RequestBody ToBePaid toBePaid){
        ToBePaid savedToBePaid = toBePaidService.saveTransactionPayment(toBePaid);
        return new ResponseEntity<>(savedToBePaid, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ToBePaid>> getAllTransactionPayment(){
        List<ToBePaid> toBePaids = toBePaidService.getTransactionPayment();
        return new ResponseEntity<>(toBePaids, HttpStatus.OK);
    }

    @GetMapping("/amount-to-be-paid")
    public ResponseEntity<List<ToBePaid>> getToBePaidEachEmployee(){
        List<ToBePaid> toBePaids = toBePaidService.getAmountToBePaidForEachEmployee();
        return new ResponseEntity<>(toBePaids, HttpStatus.OK);
    }
}
