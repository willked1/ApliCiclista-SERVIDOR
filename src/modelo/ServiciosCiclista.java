/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import estructural.Ciclista;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.IActualizableCiclista;

/**
 *
 * @author William Duarte
 */
public class ServiciosCiclista extends UnicastRemoteObject implements IServicioCiclista{
    
    private ArrayList <Ciclista> ciclistas;
    private ArrayList<IActualizableCiclista> actualizable;

    
    public ServiciosCiclista() throws RemoteException{
        ciclistas = new ArrayList<>();
        actualizable = new ArrayList<>();
    }
    
    public void addVista(IActualizableCiclista gui) throws RemoteException{
        actualizable.add(gui);
    }

    private void cambio(){
        for(IActualizableCiclista gui :actualizable){
            try {
                gui.cambio();
            } catch (RemoteException ex) {
                Logger.getLogger(ServiciosCiclista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList darCiclistas() throws RemoteException
    {
        return ciclistas;
    }
    
   
    
    //retorna true si el ciclista existe en el arreglo - false si no
    public boolean buscarPorNumero(int pNumero) throws RemoteException
    {
        boolean encontro = false;
        if(ciclistas.isEmpty())
        {
            return encontro;
        }
        else
        {
            for (int i = 0; i < ciclistas.size() && !encontro; i++) {
                Ciclista buscar = ciclistas.get(i);
                if(buscar.getNumero() == pNumero)
                {
                    encontro = true;
                }
            }
            return encontro;
        }
    }
    
    //retorna el ciclista existe en el Array - Null si no
    public Ciclista buscarPorCiclista(int pNumero) throws RemoteException
    {
        boolean encontro = false;
        Ciclista buscado = null;
        if(ciclistas.isEmpty())
        {
            return buscado;
        }
        else
        {
            for (int i = 0; i < ciclistas.size() && !encontro; i++) {
                Ciclista buscar = ciclistas.get(i);
                if(buscar.getNumero() == pNumero)
                {
                    encontro = true;
                    buscado = buscar;
                }
            }
            return buscado;
        }
    }

    //Adiciona al Array el ciclista que viene por parametro si no existe el numero en el arreglo
    // true = adiciona
    public boolean addCiclistaArray(Ciclista p) throws RemoteException
    {        
        boolean buscar = buscarPorNumero(p.getNumero());
        boolean adicionar = false;
        if(!buscar)
        {
            ciclistas.add(p);
            adicionar = true;            
            cambio();   
        }
        return adicionar;
    }
    

    //Elimina del Array el ciclista que viene por parametro si existe el numero en el arreglo
    // true = eliminó
    public boolean deleteCiclistaArray(int pNumero) throws RemoteException
    {
        boolean eliminado = false;
        boolean buscar = buscarPorNumero(pNumero);
        
        if(buscar)
        {
            Ciclista buscado = buscarPorCiclista(pNumero);
            ciclistas.remove(buscado);
            cambio();
            eliminado = true;
        }
        return eliminado;
    }
    
    //Busca un ciclista según el numero entrado por parámetro
    //Si lo encuetra retorna el ciclista
    public Ciclista consultarCiclista(int numero) throws RemoteException
    {
        Ciclista p = buscarPorCiclista(numero);
        return p;
    }
    
    
    //Actualiza el ciclista con base en el número recibido por parámetro
    // true = actualizó
    public void actualizarCiclista(int numAct, Ciclista p) throws RemoteException
    {
        Ciclista x = buscarPorCiclista(numAct);
        x.setNombre(p.getNombre());
        x.setNumero(p.getNumero());
        x.setEquipo(p.getEquipo());
        cambio();        
    }
}
