package org.example.Repository;

import org.example.Entities.Proveedor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProveedorRepository  extends BaseRepository<Proveedor, Long>{

    Optional<Proveedor> findByNombreProveedor(String nombreProveedor);
    Optional<Proveedor> findByCuitProveedor (Long cuitProveedor);
}
