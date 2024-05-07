/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV7.dao;

import com.ejerciciosTrimestre.maquinaHeladosV7.biz.Helado;
import com.ejerciciosTrimestre.maquinaHeladosV7.utils.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alex
 *
 */
public class ExtraDAOimpl implements ExtraDAO, AutoCloseable {

    Connection con = null;

    static {
        Utils.cargarDriver();
    }

    public ExtraDAOimpl() throws Exception {
        con = DriverManager.getConnection(Utils.URL);
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
        String sql = "SELECT nombre, precio, tipo, cantidad, posicion FROM helado ORDER BY Precio";

        try (PreparedStatement pstm = con.prepareStatement(sql); ResultSet rs = pstm.executeQuery();) {
            while (rs.next()) {
                ListaHeladosOrdenada.add(new Helado(
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
        int registrosAfectados = 0;
        String sql = "INSERT INTO helado VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = con.prepareStatement(sql);) {

            pstm.setString(1, helado.getPosicion());
            pstm.setString(2, helado.getSabor());
            pstm.setDouble(3, helado.getPrecio());
            pstm.setString(4, helado.getTipo());
            pstm.setInt(5, 5);
            registrosAfectados = pstm.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

        return registrosAfectados;
    }

    @Override
    public int removeHeladoByPosicion(String posicion) throws Exception {
        int registrosAfectados = 0;
        String sql = "DELETE FROM helados WHERE posicion = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(2, posicion);
            registrosAfectados = pstm.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

        return registrosAfectados;
    }

    @Override
    public double getDineroRecaudado() throws Exception {
        double dineroRecaudado = 0.0;
        String sql = "SELECT SUM(precio) AS ganancias FROM venta GROUP BY nombre";
        try (PreparedStatement pstm = con.prepareStatement(sql); ResultSet rs = pstm.executeQuery();) {
            if (rs.next()) {
                dineroRecaudado = rs.getDouble("ganancias");
            }
        } catch (Exception e) {
            throw e;
        }
        return dineroRecaudado;
    }

    @Override
    public Helado getHeladoMasVendido() throws Exception {
        Helado heladoMasVendido = null;
        String sql = "SELECT nombre, precio, tipo, SUM(cantidad) AS cantidad, posicion FROM venta GROUP BY nombre ORDER BY SUM(cantidad) DESC LIMIT 1";

        try (PreparedStatement pstm = con.prepareStatement(sql);) {

            try (ResultSet rs = pstm.executeQuery()) {
                heladoMasVendido = new Helado(rs.getString("nombre"), rs.getDouble("precio"), rs.getString("tipo"), rs.getInt("cantidad"), rs.getString("posicion"));
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }

        return heladoMasVendido;
    }

    @Override
    public void close() throws Exception {
        con.close();
    }

    @Override
    public Helado getHeladoMenosVendido() throws Exception {
        Helado heladoMenosVendido = null;
        String sql = "SELECT nombre, precio, tipo, SUM(cantidad) AS cantidad, posicion FROM venta GROUP BY nombre ORDER BY SUM(cantidad) LIMIT 1";

        try (PreparedStatement pstm = con.prepareStatement(sql);) {

            try (ResultSet rs = pstm.executeQuery()) {
                heladoMenosVendido = new Helado(rs.getString("nombre"), rs.getDouble("precio"), rs.getString("tipo"), rs.getInt("cantidad"), rs.getString("posicion"));
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }

        return heladoMenosVendido;
    }

}
