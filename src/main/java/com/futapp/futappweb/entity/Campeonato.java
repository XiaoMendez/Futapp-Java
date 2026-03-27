package com.futapp.futappweb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CAMPEONATO")
@Data
@NoArgsConstructor
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_campeonato")
    @SequenceGenerator(name = "seq_campeonato", sequenceName = "SEQ_CAMPEONATO", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "ID_FEDERACION")
    private Federacion federacion;
}