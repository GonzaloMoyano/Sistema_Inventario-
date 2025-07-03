package org.example.Entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Articulo_Proveedor")
public class ArticuloProveedor extends Base {
    private int cantidadArticulo;
    private int costoCompra;
    private float costoPorPedido;
    private int demoraEntrega;
    private int desviacionEstandar;// Atributos para intervalo fijo
    private Date FechaBajaArticulo;
    private int intervaloRevision;// Atributos para intervalo fijo
    private float precioUnitario;
    private int puntoPedido;
    private int stockSeguridad;
    private int valorCGI;

    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor proveedor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Articulo articulo;



}
