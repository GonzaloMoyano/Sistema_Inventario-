package org.example.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Venta")
public class Venta extends Base{
    private float costoTotal;
    private Date fechaVenta;

    @OneToMany(mappedBy ="venta",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticuloVenta> articuloVenta = new ArrayList<ArticuloVenta>();
}
