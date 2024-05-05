/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV7.utils;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

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
    public static class CentrarTexto extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setHorizontalAlignment(JLabel.CENTER);
            }
            return c;
        }
    }

    public static class CentrarTitulosColumnas extends JLabel implements TableCellRenderer {
        public CentrarTitulosColumnas() {
            setHorizontalAlignment(CENTER);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }
}
