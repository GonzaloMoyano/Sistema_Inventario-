package org.example.Repository;

import org.example.Entities.Articulo;

public interface ArticuloRepository extends BaseRepository<Articulo,Long>{
    boolean existsByNombreArticulo(String nombreArticulo);
}
