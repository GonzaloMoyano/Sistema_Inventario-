package org.example.Controller;

import org.example.DTOs.ArticuloDTO;
import org.example.DTOs.ProveedorDTO;
import org.example.Entities.Articulo;
import org.example.Entities.Proveedor;
import org.example.Service.ProveedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/proveedor")
public class ProveedorController extends BaseControllerImpl <Proveedor , ProveedorService>  {

    @PostMapping("/alta")
    public ResponseEntity<?> altaProveedor(@RequestBody ProveedorDTO proveedorDTO){
        try {
            Proveedor proveedor = servicio.altaProveedor(proveedorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(proveedor);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
