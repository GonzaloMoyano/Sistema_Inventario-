package org.example.Repository;

import org.example.Entities.ArticuloVenta;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends BaseRepository <ArticuloVenta, Long>{
}
