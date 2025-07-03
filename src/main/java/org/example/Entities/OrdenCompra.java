package org.example.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orden_Compra")
public class OrdenCompra extends Base {
    private int CantidadOrdenCompra;
    private float totalOrdenCompra;
    private Date fechaCancelada;
    private Date fechaPendiente;
    private Date fechaRecibida;
    private Date fechaConfirmada;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "id_Proveedor")
    private Proveedor proveedor;

    @OneToMany(cascade= CascadeType.ALL,orphanRemoval = true)
    private List<OrdenCompraArticulo> OC_Articulo = new ArrayList<OrdenCompraArticulo>();


}
