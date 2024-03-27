package com.enigmacamp.PayrollManagement.Entity;

import com.enigmacamp.PayrollManagement.Util.Constant.EPosition;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_position")
@ToString
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="position_id")
    public Long id;
    public EPosition name;

    @ManyToMany
    @JoinTable(
            name = "position_department",
            joinColumns = @JoinColumn(name="position_id"),
            inverseJoinColumns = @JoinColumn(name="department_id")
    )
    private List<Department> departments;
}
