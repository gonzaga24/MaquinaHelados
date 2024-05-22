/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV7.dao;

import com.ejerciciosTrimestre.maquinaHeladosV7.biz.Helado;
import com.ejerciciosTrimestre.maquinaHeladosV7.utils.Utils;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Alex Marcos
 *
 */
/* 
 * create table helado(
	posicion text primary key,
	nombre text not null,
	precio numeric not null,
	tipo text not null,
	cantidad integer not null
);
 */
public class HeladoDAOimpl implements HeladoDAO, AutoCloseable {

    Connection con = null;

    static {
        Utils.cargarDriver();
    }

    public HeladoDAOimpl() throws Exception {
        con = DriverManager.getConnection(Utils.URL);
    }

    @Override
    public ArrayList<Helado> getHelados() throws Exception {
        ArrayList<Helado> ListaHelados = new ArrayList<>();
        String sql = "SELECT nombre, precio, tipo, cantidad, posicion FROM helado";
        //el *
        try (PreparedStatement pstm = con.prepareStatement(sql); ResultSet rs = pstm.executeQuery();) {
            while (rs.next()) {
                ListaHelados.add(new Helado(
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getString("tipo"),
                        rs.getInt("cantidad"),
                        rs.getString("posicion")
                ));
            }
        } catch (Exception e) {
            throw e;
        }

        return ListaHelados;
    }

    @Override
    public Helado getHeladoByPosicion(String posicion) throws Exception {
        Helado h = null;
        String sql = "SELECT nombre, precio, tipo, cantidad, posicion FROM helado WHERE posicion = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, posicion);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    h = new Helado(
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getString("tipo"),
                            rs.getInt("cantidad"),
                            rs.getString("posicion")
                    );
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }

        return h;

    }

    @Override
    public int updateHelado(Helado helado) throws Exception {
        int registrosAfectados = 0;
        String sql = "UPDATE helado SET nombre = ?, tipo = ?, precio=?, cantidad = ? WHERE posicion = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1,helado.getSabor());
            pstm.setString(2,helado.getTipo());
            pstm.setDouble(3,helado.getPrecio());
            pstm.setInt(4, helado.getCantidad() );
            pstm.setString(5, helado.getPosicion());
            registrosAfectados = pstm.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

        return registrosAfectados;
    }

    @Override
    public void close() throws Exception {
        con.close();
    }

}
