package org.example.Service;

import org.example.DTOs.ArticuloDTO;
import org.example.Entities.Articulo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticuloService extends BaseService<Articulo, Long>{
    List<Articulo> altaArticulo (List<ArticuloDTO> dtoArticulos) throws Exception;
    Articulo modificarArticulo (ArticuloDTO dtoArticulo) throws Exception;
    Articulo bajaArticulo() throws Exception;
}
