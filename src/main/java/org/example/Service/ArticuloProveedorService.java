package org.example.Service;

import org.example.DTOs.ArticuloDTO;
import org.example.Entities.Articulo;
import org.example.Entities.ArticuloProveedor;
import org.springframework.stereotype.Service;

@Service
public interface ArticuloProveedorService extends BaseService<ArticuloProveedor,Long>{
    ArticuloProveedor altaArticuloProveedor(ArticuloDTO dto) throws Exception;
}
