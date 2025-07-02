package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Articulo_venta")
public class ArticuloVenta extends Base {
    private int cantArticuloVenta;
    private float precioSubTotal;
    private float precioTotal;
    private float precioUnitario;
}
