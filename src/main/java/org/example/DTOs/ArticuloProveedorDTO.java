package org.example.DTOs;

import lombok.Data;
import org.example.Entities.ModeloInventario;

@Data
public class ArticuloProveedorDTO {
    private ModeloInventario modeloInventario;
    private Long id_proveedor;
    private Long id_articulo;
    private float costoCompra;// C
    private float costoPedido;//S
    private int demoraEntrega;// L
    private int intervaloRevision;
    private float precioUnitario; // Para que pingo

}
