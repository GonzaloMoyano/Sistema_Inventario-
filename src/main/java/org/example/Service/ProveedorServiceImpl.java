package org.example.Service;

import org.example.DTOs.ProveedorDTO;
import org.example.Entities.Articulo;
import org.example.Entities.Proveedor;
import org.example.Repository.ArticuloRepository;
import org.example.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl extends BaseServiceImpl <Proveedor, Long > implements ProveedorService, Serializable {
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ArticuloProveedorService articuloProveedorService;
    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public Proveedor altaProveedor(ProveedorDTO proveedorDTO) throws Exception {
        try{
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
            proveedorNuevo.setFechaAlta(LocalDateTime.now());
            proveedorNuevo.setNombreProveedor(proveedorDTO.getNombreProveedor());

            List<Articulo> articuloList = proveedorDTO.getArticulosAsociados();
            //for ()

/*
            Optional <Articulo> articulo = articuloRepository.findById (proveedor1.get().getArticulo_Predeterminados().get().getId());
            if (!proveedor.isPresent()) {
                throw new Exception("No existe este articulo");
            }

 */

            //articuloProveedorService.altaArticuloProveedor()


            return proveedorRepository.save(proveedorNuevo);

        } catch (Exception e) {
            throw new Exception("No se pudo crear el proveedor" + e.getMessage());
        }



    }
}
