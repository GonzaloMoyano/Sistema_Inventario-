package org.example.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orden_Compra_Articulo")
public class OrdenCompraArticulo extends Base{
    private int cantOCA;
    private float precioSubTotal;
    private float precioUnitario;
}
