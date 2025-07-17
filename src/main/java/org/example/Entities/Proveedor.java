package org.example.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proveedor")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Proveedor extends Base{
    @Column(name = "nombre_proveedor", nullable = false)
    private String nombreProveedor;

    @Column(name = "cuit_proveedor", nullable = false)
    private Long cuitProveedor;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenCompra> OC;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticuloProveedor> articulo_proveedor;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Articulo> articulo_Predeterminados;

}
