/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV6.utils;

/**
 *
 * @author Alex
 *
 */
public class Utils {

    public static final String URL = "jdbc:sqlite:./helados.db";
    
    public static void cargarDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            System.exit(1);
        }
    }

    public static double redondearDecimales(double d) {
        return 1.0d * Math.round(d * 100.0d) / 100.0d;
    }

}
