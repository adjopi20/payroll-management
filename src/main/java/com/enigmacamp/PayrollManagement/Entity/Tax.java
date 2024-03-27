package com.enigmacamp.PayrollManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tax")
@ToString
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tax_id")
    private String id;

    private float taxPercentage;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
