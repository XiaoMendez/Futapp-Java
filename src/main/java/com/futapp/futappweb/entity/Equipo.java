package com.futapp.futappweb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
@Table(name = "EQUIPO")
@Data
@NoArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_equipo")
    @SequenceGenerator(name = "seq_equipo", sequenceName = "SEQ_EQUIPO", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_CREACION")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCreacion;

    @Column(name = "PAIS")
    private String pais;

    @Column(name = "CIUDAD")
    private String ciudad;

    @Column(name = "DIVISION")
    private Integer division;

    @ManyToOne
    @JoinColumn(name = "ID_FEDERACION")
    private Federacion federacion;
}