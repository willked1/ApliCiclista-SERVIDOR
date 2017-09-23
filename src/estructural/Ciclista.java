/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructural;

import java.io.Serializable;

/**
 *
 * @author William Duarte
 */
public class Ciclista implements Serializable{
    private String nombre;
    private int numero;
    private String equipo;

    public Ciclista(String nombre,int numero, String equipo) {
        this.nombre = nombre;
        this.numero = numero;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    
}
