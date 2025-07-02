package org.example.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
