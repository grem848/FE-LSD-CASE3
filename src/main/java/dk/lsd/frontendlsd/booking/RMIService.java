package dk.lsd.frontendlsd.booking;

import booking.Contract;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIService {
    // name =  rmi:// + ServerIP +  /EngineName;
    private String remoteEngine = "rmi://car-renting-service.herokuapp.com/BookingServices";


    // static variable single_instance of type Singleton 
    private static RMIService rmiService = null;

    // variable of type String 
    public Contract contract;

    // private constructor restricted to this class itself 
    private RMIService() throws RemoteException, NotBoundException, MalformedURLException {
        contract = (Contract) Naming.lookup(remoteEngine);
    }

    // static method to create instance of Singleton class 
    public static RMIService getInstance() throws RemoteException, NotBoundException, MalformedURLException {
        if (rmiService == null)
            rmiService = new RMIService();

        return rmiService;
    }
}