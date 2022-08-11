import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SorterServer implements Sorter {
    public SorterServer() throws RemoteException {}
    
    public void pushValue(int value) throws RemoteException {
        System.out.println("Value pushed: " + value);
        return;
    }
    
    public void pushOperator(String operator) throws RemoteException {
        System.out.println("Run " + operator + " successfully");
        return;
    }
    
    public int pop() throws RemoteException {
        System.out.println("Popped successfully");
        return 0;
    }

    public boolean isEmpty() throws RemoteException {
        System.out.println("Check Empty Successfully");
        return false;
    }

    public int delayPop(int millis) throws RemoteException {
        System.out.println("Delay Pop in " + millis + " millis successfully");
        return millis;
    }
    
    public static void main(String[] args) {
        try{
        SorterImplementation obj = new SorterImplementation();
        Sorter stub = (Sorter) UnicastRemoteObject.exportObject(obj, 0);

        //Bind the remote object's stub in the registry
        Registry registry = LocateRegistry.getRegistry();
        registry.bind("Sorter", stub);

        System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

    }
    
}
