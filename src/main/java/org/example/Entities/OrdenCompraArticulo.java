package org.example.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Orden_Compra_Articulo")
public class OrdenCompraArticulo extends Base{
    private int cantOCA;
    private float precioSubTotal;
    private float precioUnitario;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "Id_OrdenCompra")
    private OrdenCompra OC;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "Id_Articulo")
    private Articulo articulo;
}
