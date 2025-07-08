package org.example.Service;

import org.example.DTOs.ArticuloDTO;
import org.example.Entities.Articulo;
import org.example.Repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloServiceImpl extends BaseServiceImpl <Articulo, Long> implements ArticuloService, Serializable {
    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public List<Articulo> altaArticulo(List<ArticuloDTO> dtoArticulos) throws Exception {
        try {
            List<Articulo> articulosGuardado = new ArrayList<Articulo>();
            for (ArticuloDTO dto : dtoArticulos) {
                if(articuloRepository.existsByNombreArticulo(dto.getNombreArticulo())){
                    throw new Exception("Este articulo ya existe");
                }
                if (dto.getNombreArticulo() == null || dto.getNombreArticulo().isEmpty()) {
                    throw new Exception("El nombre del articulo es obligatorio");
                }
                if (dto.getPrecioVentaArt() == null || dto.getPrecioVentaArt() < 0) {
                    throw new Exception("El precio es obligatorio y deber ser mayor a 0");
                }
                if (dto.getStockActual() == null || dto.getStockActual() < 0) {
                    throw new Exception("El stock debe ser mayor a 0");
                }
                if (dto.getDemandaArticulo() == null || dto.getDemandaArticulo() < 0) {
                    throw new Exception("La demanda debe ser mayor a 0");
                }
                if (dto.getCostoAlmacenamiento() == null || dto.getCostoAlmacenamiento() < 0) {
                    throw new Exception("El costo de almanecenamiento debe ser mayor a 0");
                }
                if (dto.getDescripcionArticulo() == null || dto.getDescripcionArticulo().isEmpty()) {
                    throw new Exception("La descripción es obligatoria");
                }

                Articulo articulo = new Articulo();
                articulo.setNombreArticulo(dto.getNombreArticulo());
                articulo.setDescripcionArticulo(dto.getDescripcionArticulo());
                articulo.setPrecioVentaArticulo(dto.getPrecioVentaArt());
                articulo.setDemandaArticulo(dto.getDemandaArticulo());
                articulo.setStockActual(dto.getStockActual());
                articulo.setCostoAlmacenamiento(dto.getCostoAlmacenamiento());
                articulosGuardado.add(articuloRepository.save(articulo));
            }
            return articulosGuardado;
        }catch(Exception e){
                throw new Exception("No se pudo crear el articulo: " + e.getMessage());
            }
    }

    @Override
    public Articulo modificarArticulo(ArticuloDTO dto) throws Exception {
        return null;
    }

    @Override
    public Articulo bajaArticulo() throws Exception {
        return null;
    }
}
