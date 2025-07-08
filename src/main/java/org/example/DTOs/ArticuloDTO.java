package org.example.DTOs;

import lombok.Data;

@Data
public class ArticuloDTO {

    private String nombreArticulo;
    private String descripcionArticulo;
    private Float precioVentaArt;
    private Float costoAlmacenamiento;
    private Integer stockActual;
    private Integer demandaArticulo;
    private Long idProveedorPredeterminado;
}
