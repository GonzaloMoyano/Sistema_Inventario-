package org.example.DTOs;

import lombok.Data;
import org.example.Entities.ModeloInventario;

@Data
public class ArticuloProveedorDTO {
    private float costoCompra;
    private float costoPedido;
    private int demoraEntrega;
    private float precioUnitario;
    private ModeloInventario modeloInventario;
    private Long id_proveedor;
    private Long id_articulo;
}
