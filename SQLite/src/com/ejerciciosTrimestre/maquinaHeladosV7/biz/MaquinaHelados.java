package com.ejerciciosTrimestre.maquinaHeladosV7.biz;

import com.ejerciciosTrimestre.maquinaHeladosV7.dao.ExtraDAOimpl;
import com.ejerciciosTrimestre.maquinaHeladosV7.dao.HeladoDAOimpl;
import com.ejerciciosTrimestre.maquinaHeladosV7.dao.VentaDAOimpl;
import com.ejerciciosTrimestre.maquinaHeladosV7.exceptions.NotEnoughMoneyException;
import com.ejerciciosTrimestre.maquinaHeladosV7.exceptions.NotEnoughtSellsException;
import com.ejerciciosTrimestre.maquinaHeladosV7.exceptions.NotValidPositionException;
import com.ejerciciosTrimestre.maquinaHeladosV7.exceptions.QuantityExceededException;
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
    
    public ArrayList<Helado> getHeladosOrderByPrecio() throws Exception {
        ArrayList<Helado> listaHelados;
        try (ExtraDAOimpl edi = new ExtraDAOimpl();) {
            listaHelados = edi.getHeladosOrderByPrecio();
        } catch (Exception e) {
            throw e;
        }

        return listaHelados;
    }

    public ArrayList<Helado> getHelados() throws Exception {
        ArrayList<Helado> listaHelados;
        try (HeladoDAOimpl hdi = new HeladoDAOimpl();) {
            listaHelados = hdi.getHelados();
        } catch (Exception e) {
            throw e;
        }

        return listaHelados;
    }

    public ArrayList<Venta> getVentas() throws Exception {
        ArrayList<Venta> listaVentas;
        try (VentaDAOimpl vdi = new VentaDAOimpl();) {
            listaVentas = vdi.getVentas();
        } catch (Exception e) {
            throw e;
        }

        return listaVentas;
    }

    public Helado pedirHelado(String posicion) throws NotEnoughMoneyException, QuantityExceededException, NotValidPositionException, Exception {
        Helado h;
        try (VentaDAOimpl vdi = new VentaDAOimpl(); HeladoDAOimpl hdi = new HeladoDAOimpl();) {
            //Si la posición tiene dos valores y el monedero es mayor que el precio le damos el helado.
            //Si la posición no existe lanzar "NotValidPositionException"
            h = hdi.getHeladoByPosicion(posicion);

            if (h == null) {
                throw new NotValidPositionException("La posición introducida no es correcta.");
            } else //Si no tiene suficiente dinero lanzar "NotEnoughMoneyException"
            if (this.monedero < h.getPrecio()) {
                throw new NotEnoughMoneyException("No tiene suficiente dinero.");
            } else //Si los helados estan agotados lanzar "QuantityExceededException"
            if (h.getCantidad() <= 0) {
                throw new QuantityExceededException("En la posición indicada se han agotado los helados.");
            } else {
                //Le quitamos uno a la cantidad de helados
                h.setCantidad(h.getCantidad() - 1);
                hdi.updateHelado(h);
                //Le restamos al monedero el precio del helado
                this.monedero = this.monedero - h.getPrecio();
                //Sumamos a los ingresos el precio del helado
                this.ingresos = this.ingresos + h.getPrecio();

                //Añadir la venta a la tabla
                vdi.inputVenta(new Venta(h.getPosicion(), h.getSabor(), h.getPrecio(), h.getTipo(), 1));
            }
        } catch (Exception e) {
            throw e;
        }
        return h;
    }

    public double getDineroRecaudado() throws Exception {
        double dineroRecaudado = 0;
        try (ExtraDAOimpl edi = new ExtraDAOimpl();){
            dineroRecaudado = edi.getDineroRecaudado();
        }catch (Exception e){
            throw e;
        }
        return dineroRecaudado;
    }
    
    public Helado getHeladoMasVendido() throws Exception {
        Helado h = null;
        try (ExtraDAOimpl edi = new ExtraDAOimpl();) {
            h = edi.getHeladoMasVendido();
            if (h == null) {//cuando no hay ventas se muestra esto
                throw new NotEnoughtSellsException("No se ha vendido ningun helado");
            } else {
                return h;
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public int eliminarHelado(String posicion) throws Exception {

        int registrosModificados;

        try (ExtraDAOimpl edi = new ExtraDAOimpl();) {
            registrosModificados = edi.removeHeladoByPosicion(posicion);
            if (registrosModificados == 0) {
                throw new NotValidPositionException("La posición introducida no es correcta.");

            }
            return registrosModificados;
        } catch (Exception e) {
            throw e;
        }

    }
    
    public Helado getHeladoMenosVendido() throws Exception {
        Helado h = null;
        try (ExtraDAOimpl edi = new ExtraDAOimpl();) {
            h = edi.getHeladoMenosVendido();
            if (h == null) {//cuando no hay ventas se muestra esto
                throw new NotEnoughtSellsException("No se ha vendido ningun helado");
            } else {
                return h;
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public int reponerHelado(String posicion) throws Exception {
        int registrosModificados;
        try(ExtraDAOimpl edi = new ExtraDAOimpl();) {
            registrosModificados = edi.restockHeladoByPosicion(posicion);
            if (registrosModificados == 0) {
                throw new NotValidPositionException("La posición introducida no es correcta.");
            }
        } catch (Exception e) {
            throw e;
        }
        return registrosModificados;
    }
    
    public int inputHelado(String posicion, String sabor, double precio, String tipo) throws Exception {
        int registrosAfectados;
        Helado helado = new Helado(sabor, precio, tipo, 0, posicion);
        try(ExtraDAOimpl edi = new ExtraDAOimpl();) {
            registrosAfectados = edi.inputHelado(helado);                
        } catch (Exception e) {
            throw e;
        }
        
        return registrosAfectados;
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
