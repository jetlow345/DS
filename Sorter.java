import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Stack;


//This is an interface that defines the methods for Remote Operations 
//Remote interface specifies the methods that can be invoked remotely by a client
public interface Sorter extends Remote {
    void pushValue(int value) throws RemoteException;
    void pushOperator(String operator) throws RemoteException;
    int pop() throws RemoteException;
    boolean isEmpty() throws RemoteException;
    int delayPop(int millis) throws RemoteException;
    Stack<Integer> getVal() throws RemoteException;
}
