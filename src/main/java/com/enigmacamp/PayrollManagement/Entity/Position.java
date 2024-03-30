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
    public Long id;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    public EPosition name;

}
