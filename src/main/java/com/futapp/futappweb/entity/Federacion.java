package com.futapp.futappweb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FEDERACION")
@Data
@NoArgsConstructor
public class Federacion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_federacion")
    @SequenceGenerator(name = "seq_federacion", sequenceName = "SEQ_FEDERACION", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;
}
