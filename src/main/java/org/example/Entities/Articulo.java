package org.example.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articulos")
public class Articulo extends Base {


    private float costoAlmacenamiento;
    private int demandaArticulo;
    private String descripcionArticulo;
    private String nombreArticulo;
    private int precioVentaArticulo;
    private int stockActual;


    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "Id_Proveedor_Predeterminado")
    private Proveedor proveedor;

}
