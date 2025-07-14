package org.example.Service;

import org.example.DTOs.ProveedorDTO;
import org.example.Entities.Proveedor;
import org.example.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProveedorServiceImpl extends BaseServiceImpl <Proveedor, Long > implements ProveedorService, Serializable {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Proveedor altaProveedor(ProveedorDTO proveedorDTO) throws Exception {

            Optional <Proveedor> proveedor = proveedorRepository.findByNombreProveedor (proveedorDTO.getNombreProveedor());
            if (proveedor.isPresent()) {
                throw new Exception("Ya existe un proveedor con este Nombre");
            }

            Optional <Proveedor> proveedor1 = proveedorRepository.findByCuitProveedor (proveedorDTO.getCuitProveedor());
            if (proveedor1.isPresent()) {
                throw new Exception("Ya existe un proveedor con este CUIT");
            }

            if (proveedorDTO.getNombreProveedor() == null || proveedorDTO.getNombreProveedor().isEmpty()) {
                throw new Exception("El proveedor debe tener Nombre");
            }
            if (proveedorDTO.getCuitProveedor() <= 0) {
                throw new Exception("El proveedor debe tener CUIT válido");
            }

            Proveedor proveedorNuevo = new Proveedor();
            proveedorNuevo.setCuitProveedor(proveedorDTO.getCuitProveedor());
            proveedorNuevo.setFechaHoraAlta(LocalDateTime.now());
            proveedorNuevo.setNombreProveedor(proveedorDTO.getNombreProveedor());
            return proveedorRepository.save(proveedorNuevo);

    }
}
