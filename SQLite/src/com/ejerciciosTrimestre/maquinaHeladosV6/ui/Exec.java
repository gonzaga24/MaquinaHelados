package com.ejerciciosTrimestre.maquinaHeladosV6.ui;

import com.ejerciciosTrimestre.maquinaHeladosV6.biz.Helado;
import com.ejerciciosTrimestre.maquinaHeladosV6.biz.MaquinaHelados;
import com.ejerciciosTrimestre.maquinaHeladosV6.exceptions.NotEnoughMoneyException;
import com.ejerciciosTrimestre.maquinaHeladosV6.exceptions.NotValidPositionException;
import com.ejerciciosTrimestre.maquinaHeladosV6.exceptions.QuantityExceededException;
import java.util.Scanner;

/**
 *
 * @author Alex
 *
 */
public class Exec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaquinaHelados mh = new MaquinaHelados();
        Helado aux = null;
        String respuesta, posicion;
        double monedas;
        boolean encendido = true;

        do {
            //Menu inicial.
            respuesta = menuInicial(sc, mh);

            if (respuesta.equals("1")) {
                //Mostrar helados
                mostrarHelados(mh);
            } else if (respuesta.equals("2")) {
                //Introducir monedas
                monedas = introducirMonedas(sc);
                //Sumar al monedero las monedas que haya introducido por el metodo.
                mh.setMonedero(mh.getMonedero() + monedas);
            } else if (respuesta.equals("3")) {
                //Pedir helado.
                //Pedir posición del helado y si el dinero es suficiente o hay helados suficientes le daremos el helado.
                System.out.print("Introduzca la posición del helado que desea(12): ");
                posicion = sc.nextLine();
                try {
                    aux = mh.pedirHelado(posicion);
                    if (!(aux == null)) {
                        System.out.println("Puede recoger su helado de " + aux.getSabor());
                        System.out.println("Su cambio es: " + mh.getMonedero() + "€");
                        mh.setMonedero(0);
                    }
                } catch (NotEnoughMoneyException | NotValidPositionException | QuantityExceededException e) {
                    System.out.println(e.getMessage());
                }
            } else if (respuesta.equals("4")) {
                encendido = mh.apagarMaquina();
            }
        } while (encendido);
        System.out.println("Hasta la proxima!!!");
    }

    public static void mostrarHelados(MaquinaHelados mh) {
        System.out.println(mh);
    }

    public static String menuInicial(Scanner sc, MaquinaHelados mh) {
        String r;

        do {
            System.out.println("\t" + "Menú");
            System.out.println("----------------------");
            System.out.println("(1) Mostrar helados");
            System.out.println("(2) Introducir monedas");
            System.out.println("(3) Pedir helados");
            System.out.println("(4) Apagar maquina");
            System.out.println("----------------------");
            System.out.println("Tienes " + mh.getMonedero() + "€");
            System.out.println("----------------------");
            r = sc.nextLine();

            if (r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4")) { //Comprobación
                return r;
            } else {
                System.out.println("Valor incorrecto");
                System.out.println();
            }
        } while (true);

    }

    public static double introducirMonedas(Scanner sc) {
        String resp;
        double r = 0;

        System.out.println("\t" + "Introduzca monedas");
        System.out.println("---------------------------------------------------------------");
        System.out.println("(1) 2€              (2) 1€              (3) 50 cents    (4) 20 cents");
        System.out.println("(5) 10 cents    (6) 5 cents       (7) 2 cents      (8) 1 cent");
        System.out.println("(fin) Para dejar de introducir monedas");
        System.out.println("---------------------------------------------------------------");

        do {
            resp = sc.nextLine();

            if (resp.equalsIgnoreCase("fin") || resp.equals("1") || resp.equals("2") || resp.equals("3") || resp.equals("4") || resp.equals("5") || resp.equals("6") || resp.equals("7") || resp.equals("8")) {
                if (resp.equals("1")) {
                    r = r + 2;
                } else if (resp.equals("2")) {
                    r = r + 1;
                } else if (resp.equals("3")) {
                    r = r + 0.50;
                } else if (resp.equals("4")) {
                    r = r + 0.20;
                } else if (resp.equals("5")) {
                    r = r + 0.10;
                } else if (resp.equals("6")) {
                    r = r + 0.05;
                } else if (resp.equals("7")) {
                    r = r + 0.02;
                } else if (resp.equals("8")) {
                    r = r + 0.01;
                }
            } else {
                System.out.println("Valor incorrecto");
                System.out.println();
            }
        } while (!(resp.equalsIgnoreCase("fin")));
        System.out.println("Has introducido " + r + "€");
        return r;
    }

}
