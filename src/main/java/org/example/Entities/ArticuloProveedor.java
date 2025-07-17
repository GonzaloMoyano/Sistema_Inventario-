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

    private Integer cantidadArticulo;
    private Date FechaBajaArticulo;
    private Integer demoraEntrega;
    private float precioUnitario;


    private Integer desviacionEstandar;// Atributos para intervalo fijo
    private Integer intervaloRevision;// Atributos para intervalo fijo

    private Integer loteOptimo; // Se calcula
    private Integer puntoPedido;// Se calcula
    private float costoCompra;//Se calcula
    private float costoAlmacenamiento;
    private float costoPedido;
    private float valorCGI; // Se calcula
    private Integer stockSeguridad; // Se calcula
    private float costoPorPedido; // Se calcula

    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Articulo articulo;

    @Enumerated (EnumType.STRING)
    private ModeloInventario modeloInventario;

}
