package com.futapp.futappweb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("ENTRENADOR")
@Table(name = "ENTRENADOR")
@PrimaryKeyJoinColumn(name = "ID_PERSONA")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Entrenador extends Persona {

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "SALARIO")
    private Double salario;

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO")
    private Equipo equipo;
}
