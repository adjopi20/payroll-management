package com.enigmacamp.PayrollManagement.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tobepaid_detail")
public class ToBePaid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    private long penalty;
    private long bonus;

    @Column(name = "net_salary")
    private Integer netSalary;
}
