import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class SorterClient {
    // private SorterClient(){}
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry();
            Sorter stub = (Sorter) registry.lookup("Sorter");
            stub.pushValue(1);
            System.out.println(stub.getStack());

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
