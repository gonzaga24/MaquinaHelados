package com.ejerciciosTrimestre.maquinaHeladosV6.BIZ;

import com.ejerciciosTrimestre.maquinaHeladosV6.excepciones.NotEnoughMoneyException;
import com.ejerciciosTrimestre.maquinaHeladosV6.excepciones.NotValidPositionException;
import com.ejerciciosTrimestre.maquinaHeladosV6.excepciones.QuantityExceededException;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Alex
 *
 */
public class MaquinaHelados {

    private double monedero;
    private double ingresos;
    private Map<String, Helado> helados = new TreeMap<>();

    public MaquinaHelados() {
        this.monedero = 0;
        this.ingresos = 0;
        File f = new File("./MaquinaDeHelados.csv");
        String[] lineaFichero;
        //this.helados.put("00", new Helado("Chocolate", 1.8d, "tarrina", "00"));

        try (Scanner scFiles = new Scanner(f);) {
            //Tenemos leer el archivo para introducir los datos en el Map
            while (scFiles.hasNextLine()) {
                lineaFichero = scFiles.nextLine().split(",");
                //lineaFichero[0] -> Posición
                //lineaFichero[1] -> Sabor
                //lineaFichero[2] -> Precio
                //lineaFichero[3] -> Tipo
                //lineaFichero[4] -> Cantidad

                helados.put(lineaFichero[0], new Helado(lineaFichero[1], Double.parseDouble(lineaFichero[2]), lineaFichero[3], Integer.parseInt(lineaFichero[4]), lineaFichero[0]));
            }

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al leer los datos.");
        }

    }

    @Override
    public String toString() {
        String txt = "";
        for (Helado h : helados.values()) {
            txt += h.toString() + "\n";
        }
        return txt;
    }

    public Helado pedirHelado(String posicion) throws NotEnoughMoneyException, QuantityExceededException, NotValidPositionException {
        Helado h;
        //Si la posición tiene dos valores y el monedero es mayor que el precio le damos el helado.
        //Si la posición no existe lanzar "NotValidPositionException"
        if (!this.helados.containsKey(posicion)) {
            throw new NotValidPositionException("La posición introducida no es correcta.");
        }
        //Si no tiene suficiente dinero lanzar "NotEnoughMoneyException"
        if (this.monedero < this.helados.get(posicion).getPrecio()) {
            throw new NotEnoughMoneyException("No tiene suficiente dinero.");
        }
        //Si los helados estan agotados lanzar "QuantityExceededException"
        if (this.helados.get(posicion).getCantidad() <= 0) {
            throw new QuantityExceededException("En la posición indicada se han agotado los helados.");
        }

        h = this.helados.get(posicion);
        //Le quitamos uno a la cantidad de helados
        h.setCantidad(h.getCantidad() - 1);
        //Le restamos al monedero el precio del helado
        this.monedero = this.monedero - h.getPrecio();
        //Sumamos a los ingresos el precio del helado
        this.ingresos = this.ingresos + h.getPrecio();

        return h;
    }

    public boolean apagarMaquina() {
        boolean encendido = true;
        File f = new File("./MaquinaDeHelados.csv");
        //Devolver el cambio restante.
        System.out.println("El cambio es: " + getMonedero());
        //Decir la cantidad total de dinero recaudado.
        System.out.println("Las ganacias totales son: " + getIngresos() + "€");
        
        if (f.exists()) {
            try(FileWriter fw = new FileWriter(f);) {
                for (Helado helado : helados.values()) {
                    fw.write(helado.toCSV(helado) + "\n");
                }
                encendido = false;
            }catch(Exception e) {
                System.out.println("Ha ocurrido al guardar la información.");
            }
        }
        return encendido;
    }

    public double getMonedero() {
        return monedero;
    }

    public void setMonedero(double monedero) {
        this.monedero = monedero;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

}
