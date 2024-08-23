package com.example.riwi.Taller.Eventos.Entities;

import jakarta.persistence.*;



import java.util.Date;

@Entity
@Table(name = "Eventos")
public class Events {
    @Id
    @GeneratedValue(generator = "UUID")
    private String id;

    private String nombre;

    private Date fecha;

    private String ubicacion;

    private int capacidad;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
