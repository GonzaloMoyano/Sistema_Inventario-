package org.example.Service;

import org.example.DTOs.ArticuloDTO;
import org.example.DTOs.ArticuloProveedorDTO;
import org.example.Entities.ArticuloProveedor;

import java.io.Serializable;

public class ArticuloProveedorServiceImpl extends BaseServiceImpl <ArticuloProveedor, Long> implements ArticuloProveedorService, Serializable {
    @Override
    public ArticuloProveedor altaArticuloProveedor(ArticuloProveedorDTO dto) throws Exception {
        //Validar datos del articuloProveedorDTO
        // Crear el articuloProveedor
        //Seteamos los valores de ArticuloProveedorDTO en ArticuloProveedor
        // Setear los atributos
        // setear el proveedor y el articulo
        // setear el modelo de inventario
        // y en terminos del modelo de inventario realizar los calculos

        return null;
    }

}
