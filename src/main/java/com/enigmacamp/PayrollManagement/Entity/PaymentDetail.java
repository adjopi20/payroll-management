package com.enigmacamp.PayrollManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_detail")
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_detail_id")
    private Long id;

    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "salary_id")
    private Salary salary;

    @OneToOne
    @JoinColumn(name = "tax_id")
    private Tax tax;

    private long penalty;
    private long bonus;


}
