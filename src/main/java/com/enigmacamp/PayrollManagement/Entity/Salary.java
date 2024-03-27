package com.enigmacamp.PayrollManagement.Entity;

import com.enigmacamp.PayrollManagement.Util.Constant.EDepartment;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salary")
@ToString
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "salary_id")
    private String id;
    private long basicSalary;
    private long allowance;


    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
