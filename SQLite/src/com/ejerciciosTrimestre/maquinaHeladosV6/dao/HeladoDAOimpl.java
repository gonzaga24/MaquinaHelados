/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV6.dao;

import com.ejerciciosTrimestre.maquinaHeladosV6.biz.Helado;
import com.ejerciciosTrimestre.maquinaHeladosV6.utils.Utils;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Marcos
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
        con = DriverManager.getConnection("jdbc:sqlite:./helados.db");
    }

    @Override
    public ArrayList<Helado> getHelados() throws Exception {
        ArrayList<Helado> ListaHelados = new ArrayList<>();
        String sql = "SELECT * FROM helado";

        try (PreparedStatement pstm = con.prepareStatement(sql); ResultSet rs = pstm.executeQuery();) {
            while (rs.next()) {
                ListaHelados.add(new Helado(rs.getString("nombre"), rs.getDouble("precio"), rs.getString("tipo"), rs.getInt("cantidad"), rs.getString("posicion")));
            }
        } catch (Exception e) {
            throw e;
        }

        return ListaHelados;
    }

    @Override
    public Helado getHeladoByPosicion(String posicion) throws Exception {
        Helado h;
        String sql = "SELECT * FROM helado WHERE posicion = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, posicion);

            try (ResultSet rs = pstm.executeQuery()) {
                h = new Helado(rs.getString("nombre"), rs.getDouble("precio"), rs.getString("tipo"), rs.getInt("cantidad"), rs.getString("posicion"));
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
        String sql = "UPDATE helado SET cantidad = ? WHERE posicion = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setInt(1, helado.getCantidad() - 1);
            pstm.setString(2, helado.getPosicion());
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

    @Override
    public int restockHeladoByPosicion(String posicion) throws Exception {
        int registrosAfectados = 0;
        String sql = "UPDATE helado SET cantidad = ? WHERE posicion = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setInt(1, 5);
            pstm.setString(2, posicion);
            registrosAfectados = pstm.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

        return registrosAfectados;
    }

    @Override
    public ArrayList<Helado> getHeladosOrderByPrecio() throws Exception {
        ArrayList<Helado> ListaHeladosOrdenada = new ArrayList<>();
        String sql = "SELECT * FROM helado ORDER BY Precio";

        try (PreparedStatement pstm = con.prepareStatement(sql); ResultSet rs = pstm.executeQuery();) {
            while (rs.next()) {
                ListaHeladosOrdenada.add(new Helado(rs.getString("nombre"), rs.getDouble("precio"), rs.getString("tipo"), rs.getInt("cantidad"), rs.getString("posicion")));
            }
        } catch (Exception e) {
            throw e;
        }

        return ListaHeladosOrdenada;
    }

    @Override
    public int changeSaborOrPrecioByPosicion(String posicion, String nuevoSabor, double nuevoPrecio) throws Exception {
        int registrosAfectados = 0;
        String sql = "WHERE posicion = ?";
        if (nuevoSabor.isEmpty() && Double.toString(nuevoPrecio).length() > 0) {
            sql = "UPDATE helado SET sabor = ? " + sql;
        } else if (!nuevoSabor.isEmpty() && Double.toString(nuevoPrecio).length() == 0) {
            sql = "UPDATE helado SET precio = ? " + sql;
        } else {
            sql = "UPDATE helado SET sabor = ?, precio = ? " + sql;
        }

        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            if (nuevoSabor.isEmpty() && Double.toString(nuevoPrecio).length() > 0) {
                pstm.setString(1, nuevoSabor);
                pstm.setString(2, posicion);
            } else if (!nuevoSabor.isEmpty() && Double.toString(nuevoPrecio).length() == 0) {
                pstm.setDouble(1, nuevoPrecio);
                pstm.setString(2, posicion);
            } else {
                pstm.setString(1, nuevoSabor);
                pstm.setDouble(2, nuevoPrecio);
                pstm.setString(3, posicion);
            }
            registrosAfectados = pstm.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

        return registrosAfectados;
    }

    @Override
    public int inputHelado(Helado helado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int removeHeladoByPosicion(String posicion) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
