package org.example.Repository;

import org.example.Entities.ArticuloProveedor;
import org.example.Entities.Base;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloProveedorRepository extends BaseRepository <ArticuloProveedor,Long> {
}
