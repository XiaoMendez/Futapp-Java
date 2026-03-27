package com.futapp.futappweb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PARTIDO")
@Data
@NoArgsConstructor
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_partido")
    @SequenceGenerator(name = "seq_partido", sequenceName = "SEQ_PARTIDO", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "EQUIPO_CASA")
    private Equipo equipoCasa;

    @ManyToOne
    @JoinColumn(name = "EQUIPO_VISITA")
    private Equipo equipoVisita;

    @Column(name = "GOLES_CASA")
    private Integer golesCasa = 0;

    @Column(name = "GOLES_VISITA")
    private Integer golesVisita = 0;

    @Column(name = "ESTADIO")
    private String estadio;

    @Column(name = "ASISTENCIAS")
    private Integer asistencias;

    @ManyToOne
    @JoinColumn(name = "ARBITRO_PRINCIPAL")
    private Arbitro arbitroPrincipal;

    @ManyToOne
    @JoinColumn(name = "ARBITRO_ASISTENTE1")
    private Arbitro arbitroAsistente1;

    @ManyToOne
    @JoinColumn(name = "ARBITRO_ASISTENTE2")
    private Arbitro arbitroAsistente2;

    @ManyToOne
    @JoinColumn(name = "ID_CAMPEONATO")
    private Campeonato campeonato;
}