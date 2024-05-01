/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV6.dao;

import com.ejerciciosTrimestre.maquinaHeladosV6.biz.Venta;
import com.ejerciciosTrimestre.maquinaHeladosV6.utils.Utils;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Alex Marcos
 *
 */

/*
create table venta(
	fecha_hora text
	posicion text
	nombre text
	precio numeric
	tipo text 
	cantidad integer
);
 */
public class VentaDAOimpl implements VentaDAO, AutoCloseable {

    Connection con = null;

    static {
        Utils.cargarDriver();
    }

    public VentaDAOimpl() throws Exception {
        con = DriverManager.getConnection(Utils.URL);
    }

    @Override
    public int inputVenta(Venta venta) throws Exception {
        int registrosAfectados = 0;
        String sql = "INSERT INTO venta VALUES (datetime('now'),?,?,?,?,?)";

        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, venta.getPosicion());
            pstm.setString(2, venta.getNombre());
            pstm.setDouble(3, venta.getPrecio());
            pstm.setString(4, venta.getTipo());
            pstm.setInt(5, 1);

            registrosAfectados = pstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

        return registrosAfectados;
    }

    @Override
    public ArrayList<Venta> getVentas() throws Exception {
        ArrayList<Venta> listaDeVentas = new ArrayList<>();
        String sql = "SELECT fecha_hora, posicion, nombre, precio, tipo, cantidad FROM venta";
       

        try (PreparedStatement pstm = con.prepareStatement(sql); ResultSet rs = pstm.executeQuery();) {
            while (rs.next()) {
                listaDeVentas.add(new Venta(
                        rs.getString("fecha_hora"),
                        rs.getString("posicion"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getString("tipo"),
                        rs.getInt("cantidad")
                ));
            }
        } catch (Exception e) {
            throw e;
        }

        return listaDeVentas;
    }

    @Override
    public void close() throws Exception {
        con.close();
    }    

}
