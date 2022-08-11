import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
// import java.rmi.RemoteException;
// import java.rmi.server.UnicastRemoteObject;

public class SorterServer{
public SorterServer() {
    try{
        Sorter s = new SorterImplementation();
        //Bind the remote object's stub in the registry
        Registry registry = LocateRegistry.getRegistry();
        registry.bind("Sorter", s);
        System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }    
    public static void main(String[] args) {
        new SorterServer();
    }
}

