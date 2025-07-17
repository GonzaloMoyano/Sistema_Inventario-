package org.example.DTOs;

import lombok.Data;
import org.example.Entities.Articulo;

import java.util.List;

@Data
public class ProveedorDTO {
    private String nombreProveedor;
    private Long cuitProveedor;
    private List<Articulo> articulosAsociados;

}
