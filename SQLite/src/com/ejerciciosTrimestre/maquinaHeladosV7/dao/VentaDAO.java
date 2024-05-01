/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV6.dao;

import com.ejerciciosTrimestre.maquinaHeladosV6.biz.Venta;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public interface VentaDAO {

    public int inputVenta(Venta venta) throws Exception;

    public ArrayList<Venta> getVentas() throws Exception;
}
