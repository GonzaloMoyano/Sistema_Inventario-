package org.example.Repository;

import org.example.Entities.Articulo;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends BaseRepository<Articulo,Long>{
    boolean existsByNombreArticulo(String nombreArticulo);
}
