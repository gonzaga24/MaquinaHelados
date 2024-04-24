package com.ejerciciosTrimestre.maquinaHeladosV6.biz;

/**
 *
 * @author Alex
 * 
 */
public class Helado {
    private String sabor;
    private double precio;
    private String tipo;
    private int cantidad;
    private String posicion;

    public Helado(String sabor, double precio, String tipo, int cantidad, String posicion) {
        this.sabor = sabor;
        this.precio = precio;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Posición: " + posicion + ", Sabor: " + sabor + "\t" + ", Precio: " + precio + ", Tipo de helado: " + tipo + ", \tCantidad: " + cantidad;
    }

    public String toCSV(Helado helado) {
        return helado.posicion + "," + helado.sabor + "," + helado.precio + "," + helado.tipo + "," + helado.cantidad;
    }
    
    public String getSabor() {
        return sabor;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
