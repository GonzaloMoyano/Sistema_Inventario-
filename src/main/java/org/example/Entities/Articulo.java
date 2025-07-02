package org.example.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "articulos")
public class Articulo extends Base {


    private float costoAlmacenamiento;
    private int demandaArticulo;
    private String descripcionArticulo;
    private String nombreArticulo;
    private int precioVentaArticulo;
    private int stockActual;

}
