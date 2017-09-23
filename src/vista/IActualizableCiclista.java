/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author William Duarte
 */
public interface IActualizableCiclista extends Remote{
    
    public void cambio() throws RemoteException;
    
}
