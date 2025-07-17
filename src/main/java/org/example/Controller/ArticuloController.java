package org.example.Controller;

import org.example.DTOs.ArticuloDTO;
import org.example.Entities.Articulo;
import org.example.Service.ArticuloServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articulos")
public class ArticuloController extends BaseControllerImpl <Articulo, ArticuloServiceImpl> {

    @PostMapping("/alta")
    public ResponseEntity<?> altaArticulo(@RequestBody List<ArticuloDTO> dtoArticulos){
        try {
            List<Articulo> nuevos = servicio.altaArticulo(dtoArticulos);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevos);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("/modificar")
    public ResponseEntity <?> modificarArticulo(@RequestBody ArticuloDTO dtoArticulos){
        try {
            Articulo nuevo = servicio.modificarArticulo(dtoArticulos);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo); // O devolver la lista, depende tu diseño
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("")
    @Override
    public ResponseEntity<?> getAll() {
        return super.getAll();
    }



}
