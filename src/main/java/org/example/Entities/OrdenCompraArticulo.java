package org.example.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "OrdenCompra_Articulo")
public class OrdenCompraArticulo extends Base{
    private int cantOCA;
    private float precioSubTotal;
    private float precioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrdenCompra OC;

    @ManyToOne(fetch = FetchType.LAZY)
    private Articulo articulo;

}
