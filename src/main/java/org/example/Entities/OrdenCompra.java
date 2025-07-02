package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Orden_Compra")
public class OrdenCompra extends Base {
    private int CantidadOrdenCompra;
    private float totalOrdenCompra;
    private Date fechaCancelada;
    private Date fechaPendiente;
    private Date fechaRecibida;
    private Date fechaConfirmada;


}
