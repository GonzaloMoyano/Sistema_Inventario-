package org.example.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "articulos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Articulo extends Base {

    private int demandaArticulo;
    private float costoAlmacenamiento;
    private String descripcionArticulo;
    private String nombreArticulo;
    private float precioVentaArticulo;
    private int stockActual;


    @ManyToOne(fetch = FetchType.EAGER )

    @JoinColumn(name = "Id_Proveedor_Predeterminado")
    private Proveedor proveedor;


}
