/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ejerciciosTrimestre.maquinaHeladosV6.dao;

import com.ejerciciosTrimestre.maquinaHeladosV6.biz.Venta;
import com.ejerciciosTrimestre.maquinaHeladosV6.utils.Utils;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Alex
 *
 */

/*
create table venta(
	fecha_hora text not null,
	posicion text not null,
	nombre text not null,
	precio numeric not null,
	tipo text not null,
	cantidad integer not null
);
*/
public class VentaDAOimpl implements VentaDAO, AutoCloseable {
    Connection con = null;
    static{
        Utils.cargarDriver();
    }

    public VentaDAOimpl() throws Exception{
        con = DriverManager.getConnection("jdbc:sqlite:./helados.db");
    }

    @Override
    public int inputVenta(Venta venta) throws Exception{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Venta> getVentas() throws Exception{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
