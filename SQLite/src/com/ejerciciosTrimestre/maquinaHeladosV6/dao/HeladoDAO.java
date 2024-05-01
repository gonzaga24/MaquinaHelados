/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV6.dao;

import com.ejerciciosTrimestre.maquinaHeladosV6.biz.Helado;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public interface HeladoDAO {

    public ArrayList<Helado> getHelados() throws Exception;

    public Helado getHeladoByPosicion(String posicion) throws Exception;

    public int updateHelado(Helado helado) throws Exception;
}
