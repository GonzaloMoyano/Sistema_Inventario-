package org.example.Service;

import jakarta.transaction.Transactional;
import org.example.DTOs.ArticuloDTO;
import org.example.DTOs.ArticuloProveedorDTO;
import org.example.Entities.Articulo;
import org.example.Entities.ArticuloProveedor;
import org.example.Entities.ModeloInventario;
import org.example.Entities.Proveedor;
import org.example.Repository.ArticuloProveedorRepository;
import org.example.Repository.ArticuloRepository;
import org.example.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ArticuloProveedorServiceImpl extends BaseServiceImpl <ArticuloProveedor, Long> implements ArticuloProveedorService, Serializable {
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ArticuloRepository articuloRepository;
    @Autowired
    private ArticuloProveedorRepository articuloProveedorRepository;

    @Transactional
    @Override
    public ArticuloProveedor altaArticuloProveedor(ArticuloProveedorDTO dto) throws Exception {

        //Validar datos del articuloProveedorDTO

        Optional<Proveedor> proveedor = proveedorRepository.findById (dto.getId_proveedor());
        if (!proveedor.isPresent()) {
            throw new Exception("El proveedor no existe");
        }
        Optional <Articulo> articulo = articuloRepository.findById (dto.getId_articulo());
        if (!articulo.isPresent()) {
            throw new Exception("El articulo no existe");
        }

        if (dto.getDemoraEntrega() <= 0){
            throw new Exception("La demora de entrega debe ser positiva");
        }
        if (dto.getCostoCompra() <= 0){
            throw new Exception("El costo de compra debe ser positivo");
        }
        if (dto.getCostoPedido() <= 0){
            throw new Exception("El costo de pedido debe ser positivo");
        }
        if (dto.getPrecioUnitario() <= 0){
            throw new Exception("El precio unitario debe ser positivo");
        }
        if (dto.getIntervaloRevision() <= 0){
            throw new Exception("El intervalo de revision debe ser positivo");
        }

        // Crear el articuloProveedor
        ArticuloProveedor ap= new ArticuloProveedor();
        //Seteamos los valores de ArticuloProveedorDTO en ArticuloProveedor
        ap.setArticulo(articulo.get());
        ap.setProveedor(proveedor.get());
        ap.setDemoraEntrega(dto.getDemoraEntrega());
        ap.setCostoCompra(dto.getCostoCompra());
        ap.setCostoPorPedido(dto.getCostoPedido());
        ap.setPrecioUnitario(dto.getPrecioUnitario());
        ap.setFechaAlta(LocalDateTime.now());
        ap.setEstado(true);

        articuloProveedorRepository.save(ap);
        calcularTodo(ap);



        return null;
    }




    private Integer calculoStockSeguridad(ArticuloProveedor ap) throws Exception {
        Integer stockSeguridad = 0;
        if (ap.getModeloInventario() == ModeloInventario.lotefijo) {
            stockSeguridad = (int) Math.round(1.64 * ap.getDesviacionEstandar() * Math.sqrt(ap.getDemoraEntrega()));
        } else {
            stockSeguridad = (int) Math.round(1.64 * ap.getDesviacionEstandar() * Math.sqrt(ap.getDemoraEntrega() + ap.getIntervaloRevision()));
        }
        return stockSeguridad;
    }

    private Integer calcularLoteOptimo(ArticuloProveedor Ap) throws Exception {

        Optional<Proveedor> proveedor = proveedorRepository.findById (Ap.getProveedor().getId());
        if (!proveedor.isPresent()) {
            throw new Exception("El proveedor no existe");
        }
        Optional <Articulo> articulo = articuloRepository.findById (Ap.getArticulo().getId());
        if (!articulo.isPresent()) {
            throw new Exception("El articulo no existe");
        }

        double resultado = Math.sqrt((2 * articulo.get().getDemandaArticulo() * Ap.getCostoPorPedido()) / articulo.get().getCostoAlmacenamiento());
        return (int) Math.round(resultado); // Redondeamos al entero más cercano
    }
    private Integer calcularPuntoPedido (ArticuloProveedor ap) throws Exception {
        Integer SS = calculoStockSeguridad(ap);
        Integer R = (ap.getArticulo().getDemandaArticulo()/365)*ap.getIntervaloRevision()+ SS;
        return R;
    }

    private float calcularCostoCompra(ArticuloProveedor ap) throws Exception {
        float Cc = ap.getLoteOptimo() * ap.getPrecioUnitario() ;
        return Cc;
    }

    private float calcularCostoPedido (ArticuloProveedor ap) throws Exception {
        float Cp = ((ap.getArticulo().getDemandaArticulo())/ap.getLoteOptimo())* ap.getCostoPorPedido();
        return Cp;
    }
    private float calcularCostoAlmacenamiento (ArticuloProveedor ap) throws Exception {
        float Ca = ap.getArticulo().getCostoAlmacenamiento() * (ap.getLoteOptimo()/2);
        return Ca;
    }
    private float calcularCGI (ArticuloProveedor ap) throws Exception {
        float CGI = ap.getCostoCompra() + ap.getCostoPedido()+ ap.getCostoAlmacenamiento();
        return CGI;
    }




    @Transactional

    private void calcularTodo (ArticuloProveedor articuloProveedor) throws Exception {

        articuloProveedor.setStockSeguridad(calculoStockSeguridad(articuloProveedor));
        articuloProveedor.setLoteOptimo(calcularLoteOptimo(articuloProveedor));
        if(articuloProveedor.getModeloInventario() == ModeloInventario.lotefijo){
            articuloProveedor.setPuntoPedido(calcularPuntoPedido(articuloProveedor));
        }
        articuloProveedor.setCostoCompra(calcularCostoCompra(articuloProveedor));
        articuloProveedor.setCostoPedido(calcularCostoPedido(articuloProveedor));
        articuloProveedor.setCostoAlmacenamiento(calcularCostoAlmacenamiento(articuloProveedor));
        articuloProveedor.setValorCGI(calcularCGI(articuloProveedor));
        articuloProveedorRepository.save(articuloProveedor);

    }



}
