package com.ejemplos;


import java.sql.*;
import static com.Utils.Utils.cargarDriver;

/**
 *
 * @author Alex
 *
 */
public class Test {
    public static void main(String[] args) {
        cargarDriver();
        
        String sql = "SELECT * FROM helado";
        
        try(Connection con = DriverManager.getConnection("jdbc:sqlite:./helados.db"); PreparedStatement pstm = con.prepareStatement(sql); ResultSet rs = pstm.executeQuery();) {
            while (rs.next()) {
                System.out.println(rs.getString("posicion") + "::" + rs.getString("nombre") + "::" + rs.getString("tipo") + "::" + rs.getString("precio") + "::" + rs.getString("cantidad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
