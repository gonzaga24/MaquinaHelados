/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV6.Utils;

/**
 *
 * @author Alex
 *
 */
public class Utils {

    public static void cargarDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            System.out.println("Se ha producido un error al cargar el driver");
            System.exit(1);
        }
    }
}
