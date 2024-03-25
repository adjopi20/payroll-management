package com.enigmacamp.PayrollManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_employee")
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private double salary;
    private String jobTitle;

    @OneToOne
    @JoinColumn(name="position_id")
    private Position position;

    @OneToOne
    @JoinColumn(name="department_id")
    private Department department;
}
