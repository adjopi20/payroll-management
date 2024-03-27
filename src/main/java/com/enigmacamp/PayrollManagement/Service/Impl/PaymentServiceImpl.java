package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.Department;
import com.enigmacamp.PayrollManagement.Entity.Payment;
import com.enigmacamp.PayrollManagement.Entity.PaymentDetail;
import com.enigmacamp.PayrollManagement.Repository.PaymentRepository;
import com.enigmacamp.PayrollManagement.Service.PaymentDetailService;
import com.enigmacamp.PayrollManagement.Service.PaymentService;
import com.enigmacamp.PayrollManagement.Util.Constant.EDepartment;
import com.enigmacamp.PayrollManagement.Util.Constant.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentDetailService paymentDetailService;
    private final ObjectMapper objectMapper;
    private final PaymentDetail paymentDetail = new PaymentDetail();

    @Override
    public Payment savePayment(String statusPayment) {
        try {
            Map<String, String> jsonMap = objectMapper.readValue(statusPayment, new TypeReference<Map<String, String>>() {});
            //untuk buat variabel yang dikirinya jadi yang didalam get nya itu key nya, jadi kita masukkan value nya di dalam itu
            String statusPaymentValue = jsonMap.get("status");
            //convert enum value ke enum constant
            Status status = Status.valueOf(statusPaymentValue);

            PaymentDetail paymentDetail1 = PaymentDetail.builder()
                    .bonus(paymentDetail.getBonus())
                    .build();
            paymentDetailService.saveTransactionPayment(paymentDetail1);

            Payment payment = Payment.builder()
                    .status(status)
                    .paymentDate(new Date())
                    .paymentDetail(paymentDetail1)
                    .build();
            return paymentRepository.save(payment);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
}
