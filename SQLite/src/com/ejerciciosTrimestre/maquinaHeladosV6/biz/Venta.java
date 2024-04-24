/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ejerciciosTrimestre.maquinaHeladosV6.biz;

import java.time.LocalDate;

/**
 *
 * @author Alex
 */
public class Venta {
    private LocalDate fechaHora;
    private String posicion;
    private String nombre;
    private double precio;
    private String tipo;
    private int cantidad;

    @Override
    public String toString() {
        return "Venta{" + "fechaHora=" + fechaHora + ", posicion=" + posicion + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", cantidad=" + cantidad + '}';
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
