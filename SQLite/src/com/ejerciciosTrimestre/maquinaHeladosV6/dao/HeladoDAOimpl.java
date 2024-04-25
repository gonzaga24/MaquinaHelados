/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ejerciciosTrimestre.maquinaHeladosV6.dao;

import com.ejerciciosTrimestre.maquinaHeladosV6.biz.Helado;
import com.ejerciciosTrimestre.maquinaHeladosV6.utils.Utils;
import java.util.ArrayList;
import java.sql.*;
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
    static{
        Utils.cargarDriver();
    }

    public HeladoDAOimpl() throws Exception{
        con = DriverManager.getConnection("jdbc:sqlite:./helados.db");
    }


    @Override
    public ArrayList<Helado> getHelados() throws Exception {
    ArrayList<Helado> he = new ArrayList<>();
        String sql = "SELECT * FROM helado";
        
        try (PreparedStatement pstm = con.prepareStatement(sql); ResultSet rs = pstm.executeQuery();) {
            while (rs.next()) {
                he.add(new Helado(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (Exception e) {
            throw e;
        }
        
        return he;
    }

    @Override
    public Helado getHeladoByPosicion(String posicion) throws Exception {
        Helado h;
        ResultSet rs = null;
        String sql = "SELECT nombre, precio, tipo, cantidad WHERE posicion = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql);){
            pstm.setString(1, posicion);
            rs = pstm.executeQuery();
            
          h = new Helado(rs.getString("nombre"), rs.getDouble("precio"), rs.getString("tipo"), rs.getInt("cantidad"), posicion);
            
        } catch (Exception e) {
            throw e;
        }
        
        return h;
        
    }

    @Override
    public int updateHelado(Helado helado) throws Exception {
        int r = 0;
        String sql = "UPDATE helado SET cantidad = ? where ?";
        try (PreparedStatement stm = con.prepareStatement(sql);) {
            stm.setInt(1, helado.getCantidad()-1);
            stm.setString(2, helado.getPosicion());
            r = stm.executeUpdate();
            
        }catch (Exception e ){
                throw e;
      }
        
        return r;
    }

    @Override
    public void close() throws Exception {
        con.close();
    }

    

}
