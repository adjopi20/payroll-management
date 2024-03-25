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
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    public String id;
    public EDepartment name;

    @ManyToMany(mappedBy = "department")
    public List<Position> positions;
}
