package com.futapp.futappweb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("JUGADOR")
@Table(name = "JUGADOR")
@PrimaryKeyJoinColumn(name = "ID_PERSONA")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Jugador extends Persona {

    @Column(name = "POSICION")
    private String posicion;

    @Column(name = "DORSAL")
    private Integer dorsal;

    @Column(name = "PIERNA_HABIL")
    private String piernaHabil;

    @Column(name = "ALTURA")
    private Double altura;

    @Column(name = "PESO")
    private Double peso;

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO")
    private Equipo equipo;
}
