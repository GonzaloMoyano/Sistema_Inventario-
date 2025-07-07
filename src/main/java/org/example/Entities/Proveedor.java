package org.example.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proveedor")
public class Proveedor extends Base{
    private String nombreProveedor;
    private int cuit;
    private Date fechaHoraBaja;
    private Date fechaHoraAlta;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenCompra> OC;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticuloProveedor> articulo_proveedor;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Articulo> articulo_Predeterminados;

}
