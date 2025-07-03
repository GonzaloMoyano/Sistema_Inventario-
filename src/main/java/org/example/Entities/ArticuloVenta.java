package org.example.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Articulo_venta")
public class ArticuloVenta extends Base {
    private int cantArticuloVenta;
    private float precioSubTotal;
    private float precioTotal;
    private float precioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Articulo articulo;
    @ManyToOne(fetch = FetchType.LAZY)
    private Venta venta;
}
