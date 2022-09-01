import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class SorterServer{ 
    public static void main(String[] args) {
        try{
        SorterImplementation sort = new SorterImplementation();
        
        //Bind the remote object's stub in the registry
        Registry registry = LocateRegistry.getRegistry();
        registry.bind("Sorter", sort);

        System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

    }
    
}