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
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobTitle;

    @OneToOne
    @JoinColumn(name="position_id")
    private Position position;

    @OneToOne
    @JoinColumn(name="department_id")
    private Department department;


}
