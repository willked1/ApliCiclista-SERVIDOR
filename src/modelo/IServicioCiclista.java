/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import estructural.Ciclista;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import vista.IActualizableCiclista;

/**
 *
 * @author William Duarte
 */
public interface IServicioCiclista extends Remote {
    public void addVista(IActualizableCiclista gui) throws RemoteException;
    public ArrayList darCiclistas() throws RemoteException;
    public boolean buscarPorNumero(int pNumero) throws RemoteException;
    public Ciclista buscarPorCiclista(int pNumero) throws RemoteException;
    public boolean addCiclistaArray(Ciclista p) throws RemoteException;
    public boolean deleteCiclistaArray(int pNumero) throws RemoteException;
    public Ciclista consultarCiclista(int numero) throws RemoteException;
    public void actualizarCiclista(int numAct, Ciclista p) throws RemoteException;
    
}
