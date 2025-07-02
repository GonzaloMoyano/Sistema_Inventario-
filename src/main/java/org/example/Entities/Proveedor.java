package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "proveedor")
public class Proveedor extends Base{
    private String nombreProveedor;
    private int cuit;
    private Date fechaHoraBaja;
    private Date fechaHoraAlta;

}
