package org.example.Service;

import org.example.DTOs.ArticuloProveedorDTO;
import org.example.DTOs.ProveedorDTO;
import org.example.Entities.Proveedor;
import org.springframework.stereotype.Service;

@Service
public interface ProveedorService extends BaseService <Proveedor,Long> {
    Proveedor altaProveedor(ProveedorDTO proveedorDTO) throws Exception;
}
