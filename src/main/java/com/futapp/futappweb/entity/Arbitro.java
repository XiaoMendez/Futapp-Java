package com.futapp.futappweb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("ARBITRO")
@Table(name = "ARBITRO")
@PrimaryKeyJoinColumn(name = "ID_PERSONA")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Arbitro extends Persona {

    @Column(name = "TIPO")
    private String tipo; // PRINCIPAL, ASISTENTE
}
