package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.MonthlyPayment;
import com.enigmacamp.PayrollManagement.Entity.ToBePaid;
import com.enigmacamp.PayrollManagement.Repository.MonthlyPaymentRepository;
import com.enigmacamp.PayrollManagement.Service.ToBePaidService;
import com.enigmacamp.PayrollManagement.Service.MonthlyPaymentService;
import com.enigmacamp.PayrollManagement.Util.Constant.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonthlyPaymentServiceImpl implements MonthlyPaymentService {
    private final MonthlyPaymentRepository monthlyPaymentRepository;
    private final ToBePaidService toBePaidService;
    private final ObjectMapper objectMapper;
    private final ToBePaid toBePaid = new ToBePaid();

    @Override
    public MonthlyPayment savePayment(String statusPayment) {
        try {
            Map<String, String> jsonMap = objectMapper.readValue(statusPayment, new TypeReference<Map<String, String>>() {});
            //untuk buat variabel yang dikirinya jadi yang didalam get nya itu key nya, jadi kita masukkan value nya di dalam itu
            String statusPaymentValue = jsonMap.get("status");
            //convert enum value ke enum constant
            Status status = Status.valueOf(statusPaymentValue);

            Long toBePaidId = Long.parseLong(jsonMap.get("toBePaidId")); // Assuming "toBePaidId" is provided in the JSON
            Optional<ToBePaid> optionalToBePaid = toBePaidService.getPaymentDetailById(toBePaidId);
            ToBePaid existingToBePaid = optionalToBePaid.orElseThrow(() -> new IllegalArgumentException("ToBePaid entity with ID " + toBePaidId + " not found."));


            MonthlyPayment monthlyPayment = MonthlyPayment.builder()
                    .status(status)
                    .paymentDate(new Date())
                    .toBePaid(existingToBePaid)
                    .build();
            return monthlyPaymentRepository.save(monthlyPayment);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MonthlyPayment> getAll() {
        return monthlyPaymentRepository.findAll();
    }

    @Override
    public List<MonthlyPayment> getEmployeeThatHasNotBeenPaid() {
        return monthlyPaymentRepository.getEmployeeThatHasNotBeenPaid();
    }
}
