/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apliciclistarmiservidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import modelo.IServicioCiclista;
import modelo.ServiciosCiclista;

/**
 *
 * @author William Duarte
 */
public class ApliCiclistaRMIServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String dbHost = "192.168.16.15";
	try {
            if (args.length > 0) {
                dbHost = args[0];
            }
            //puerto donde recide el servidor (model)
            LocateRegistry.createRegistry(1099);

            IServicioCiclista model = new ServiciosCiclista();
            Naming.rebind("//"+dbHost+"/ApliCiclista", model);
            System.out.println("Objeto Model en el servidor...");
    	} catch (MalformedURLException | RemoteException e) {
            System.out.println("Eror: " + e.getMessage());
    	}
    }
    
}
