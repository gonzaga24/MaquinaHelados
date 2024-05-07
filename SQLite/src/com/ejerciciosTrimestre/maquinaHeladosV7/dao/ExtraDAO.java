/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV7.dao;

import com.ejerciciosTrimestre.maquinaHeladosV7.biz.Helado;
import java.util.ArrayList;

/**
 *
 * @author Alex
 *
 */
public interface ExtraDAO {

    public int restockHeladoByPosicion(String posicion) throws Exception;

    public int removeHeladoByPosicion(String posicion) throws Exception;

    public int inputHelado(Helado helado) throws Exception;

    public int changeSaborOrPrecioByPosicion(String posicion, String nuevoSabor, double nuevoPrecio) throws Exception;

    public ArrayList<Helado> getHeladosOrderByPrecio() throws Exception;

    public double getDineroRecaudado() throws Exception;

    public Helado getHeladoMasVendido() throws Exception;

    public Helado getHeladoMenosVendido() throws Exception;
}
