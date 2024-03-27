package com.enigmacamp.PayrollManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trx_payment")
@ToString
public class TransactionPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trx_payment_id")
    private String id;

    private Date date;
    private long penalty;
    private long bonus;

    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "salary_id")
    private Salary salary;

    @OneToOne
    @JoinColumn(name = "tax_id")
    private Tax tax;

}
