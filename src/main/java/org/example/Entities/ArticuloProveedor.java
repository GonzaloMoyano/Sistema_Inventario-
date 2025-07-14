package org.example.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Table(name = "Articulo_Proveedor")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class ArticuloProveedor extends Base {

    private int cantidadArticulo;
    private int costoCompra;//Se calcula
    private float costoPorPedido; // Se calcula
    private int demoraEntrega;
    private int desviacionEstandar;// Atributos para intervalo fijo
    private Date FechaBajaArticulo;
    private int intervaloRevision;// Atributos para intervalo fijo
    private float precioUnitario;
    private int puntoPedido;// Se calcula
    private int stockSeguridad; // Se calcula
    private int valorCGI; // Se calcula

    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Articulo articulo;
    @Enumerated (EnumType.STRING)
    private ModeloInventario modeloInventario;

}
