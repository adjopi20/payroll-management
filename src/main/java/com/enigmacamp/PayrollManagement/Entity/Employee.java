package com.enigmacamp.PayrollManagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobTitle;

    @ManyToOne
    @JoinColumn(name="position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "salary_id")
    private Salary salary;

    @OneToOne
    @JoinColumn(name = "tax_id")
    private Tax taxId;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ToBePaid> toBePaid;
}
