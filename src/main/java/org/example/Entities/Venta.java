package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Venta")
public class Venta extends Base{
    private float costoTotal;
    private Date fechaVenta;

}
