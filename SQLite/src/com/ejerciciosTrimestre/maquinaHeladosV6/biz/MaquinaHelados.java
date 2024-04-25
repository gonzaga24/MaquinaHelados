package com.ejerciciosTrimestre.maquinaHeladosV6.biz;

import com.ejerciciosTrimestre.maquinaHeladosV6.dao.HeladoDAOimpl;
import com.ejerciciosTrimestre.maquinaHeladosV6.dao.VentaDAOimpl;
import com.ejerciciosTrimestre.maquinaHeladosV6.exceptions.NotEnoughMoneyException;
import com.ejerciciosTrimestre.maquinaHeladosV6.exceptions.NotValidPositionException;
import com.ejerciciosTrimestre.maquinaHeladosV6.exceptions.QuantityExceededException;
import java.util.ArrayList;

/**
 *
 * @author Alex
 *
 */
public class MaquinaHelados {

    private double monedero;
    private double ingresos;

    public MaquinaHelados() {
        this.monedero = 0;
        this.ingresos = 0;
    }
    
    
    public String mostrarHelados() throws Exception {
        String txt = "";
        try (HeladoDAOimpl hdi = new HeladoDAOimpl();) {
            ArrayList<Helado> listaHelados = hdi.getHelados();
            for (Helado h : listaHelados) {
                txt += h.toString() + "\n";
            }
        } catch (Exception e) {
            throw e;
        }
        return txt;
    }

    public Helado pedirHelado(String posicion) throws NotEnoughMoneyException, QuantityExceededException, NotValidPositionException, Exception {
        Helado h;
        try (VentaDAOimpl vdi = new VentaDAOimpl(); HeladoDAOimpl hdi = new HeladoDAOimpl();) {
            //Si la posición tiene dos valores y el monedero es mayor que el precio le damos el helado.
            //Si la posición no existe lanzar "NotValidPositionException"
            if (hdi.getHeladoByPosicion(posicion) == null) {
                throw new NotValidPositionException("La posición introducida no es correcta.");
            }
            
            h = hdi.getHeladoByPosicion(posicion);
            
            //Si no tiene suficiente dinero lanzar "NotEnoughMoneyException"
            if (this.monedero < h.getPrecio()) {
                throw new NotEnoughMoneyException("No tiene suficiente dinero.");
            }
            //Si los helados estan agotados lanzar "QuantityExceededException"
            if (h.getCantidad() <= 0) {
                throw new QuantityExceededException("En la posición indicada se han agotado los helados.");
            }
            //Le quitamos uno a la cantidad de helados
            hdi.updateHelado(h);
            //Le restamos al monedero el precio del helado
            this.monedero = this.monedero - h.getPrecio();
            //Sumamos a los ingresos el precio del helado
            this.ingresos = this.ingresos + h.getPrecio();

            //Añadir la venta a la tabla
            vdi.inputVenta(new Venta(h.getPosicion(), h.getSabor(), h.getPrecio(), h.getTipo(), h.getCantidad()));
        } catch (Exception e) {
            throw e;
        }
        return h;
    }

    public boolean apagarMaquina() {
        return false;
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
