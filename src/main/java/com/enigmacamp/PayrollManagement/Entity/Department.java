package com.enigmacamp.PayrollManagement.Entity;

import com.enigmacamp.PayrollManagement.Util.Constant.EDepartment;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    public EDepartment name;
}
