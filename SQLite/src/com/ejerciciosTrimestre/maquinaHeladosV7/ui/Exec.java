package com.ejerciciosTrimestre.maquinaHeladosV7.ui;

import com.ejerciciosTrimestre.maquinaHeladosV7.biz.Helado;
import com.ejerciciosTrimestre.maquinaHeladosV7.biz.MaquinaHelados;
import com.ejerciciosTrimestre.maquinaHeladosV7.exceptions.NotEnoughMoneyException;
import com.ejerciciosTrimestre.maquinaHeladosV7.exceptions.NotValidPositionException;
import com.ejerciciosTrimestre.maquinaHeladosV7.exceptions.QuantityExceededException;
import static com.ejerciciosTrimestre.maquinaHeladosV7.utils.Utils.redondearDecimales;
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
        String respuesta;
        boolean encendido = true;

        do {
            //Menu inicial.
            respuesta = menuInicial(sc, mh);

            if (respuesta.equals("1")) {
                try {
                    //Mostrar helados
                    System.out.println(mh.mostrarHelados());
                } catch (Exception ex) {
                    System.out.println("Ha ocurrido un error al mostrar el listado de helados.");
                }
            } else if (respuesta.equals("2")) {
                //Introducir monedas
                introducirMonedas(sc, mh);
            } else if (respuesta.equals("3")) {
                try {
                    //Pedir helado.
                    pedirHelado(sc, mh);
                } catch (NotEnoughMoneyException | NotValidPositionException | QuantityExceededException e) {
                    System.out.println(e.getMessage());
                } catch (Exception ex) {
                    System.out.println("Ha ocurrido un error al pedir el helado.");
                }
            } else if (respuesta.equals("4")) {
                apagarMaquina(mh);
                encendido = mh.apagarMaquina();
            }
        } while (encendido);
        System.out.println("Hasta la proxima!!!");
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

    public static void introducirMonedas(Scanner sc, MaquinaHelados mh) {
        String resp;
        double cantidadIntroducida = 0;

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
                    cantidadIntroducida = cantidadIntroducida + 2;
                } else if (resp.equals("2")) {
                    cantidadIntroducida = cantidadIntroducida + 1;
                } else if (resp.equals("3")) {
                    cantidadIntroducida = cantidadIntroducida + 0.50;
                } else if (resp.equals("4")) {
                    cantidadIntroducida = cantidadIntroducida + 0.20;
                } else if (resp.equals("5")) {
                    cantidadIntroducida = cantidadIntroducida + 0.10;
                } else if (resp.equals("6")) {
                    cantidadIntroducida = cantidadIntroducida + 0.05;
                } else if (resp.equals("7")) {
                    cantidadIntroducida = cantidadIntroducida + 0.02;
                } else if (resp.equals("8")) {
                    cantidadIntroducida = cantidadIntroducida + 0.01;
                }
            } else {
                System.out.println("Valor incorrecto");
                System.out.println();
            }
        } while (!(resp.equalsIgnoreCase("fin")));
        System.out.println("Has introducido " + cantidadIntroducida + "€");
        //Sumar al monedero las monedas que haya introducido por el metodo.
        mh.setMonedero(mh.getMonedero() + cantidadIntroducida);
    }

    public static void pedirHelado(Scanner sc, MaquinaHelados mh) throws Exception {
        Helado aux;
        String posicion;
        //Pedir posición del helado y si el dinero es suficiente o hay helados suficientes le daremos el helado.
        System.out.print("Introduzca la posición del helado que desea(12): ");
        posicion = sc.nextLine();
        try {
            aux = mh.pedirHelado(posicion);
            if (!(aux == null)) {
                System.out.println("Puede recoger su helado de " + aux.getSabor());
                System.out.println("Su cambio es: " + redondearDecimales(mh.getMonedero()) + "€");
                mh.setMonedero(0);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void apagarMaquina(MaquinaHelados mh) {
        //Devolver el cambio restante.
        System.out.println("El cambio es: " + mh.getMonedero());
        //Decir la cantidad total de dinero recaudado.
        System.out.println("Las ganacias totales son: " + mh.getIngresos() + "€");
    }

}
