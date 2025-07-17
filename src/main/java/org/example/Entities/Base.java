package org.example.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor

public class Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "boolean default true")
    private boolean estado = true;

    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;
    private LocalDateTime fechaBaja;


    public Base() {
        this.estado = true;
        this.fechaAlta = LocalDateTime.now();
    }

}
