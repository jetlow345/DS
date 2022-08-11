import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.Stack;


// Implements Sorter method
public class SorterImplementation extends UnicastRemoteObject implements Sorter {
    //Creates an empty stack to push and pop values
    private Stack<Integer> val;

    public SorterImplementation() throws RemoteException{
        super();
        this.val = new Stack<>();
    }

    public Stack<Integer> getStack() throws RemoteException{
        return this.val;
    }

//temporary stack
Stack <Integer> tmpStack = new Stack<Integer>();

//initialise and declare variables
int min = Integer.MAX_VALUE;
int max = Integer.MIN_VALUE;

public void pushValue(int value) throws RemoteException{
    val.push(value);
}

public void pushOperator(String operator) throws RemoteException{
    if(operator.equals("ascending")){
        Collections.sort(val);
    }
    else if(operator.equals("descending")){
        Collections.sort(val);
        Collections.reverse(val);
    }
    else if(operator.equals("min")){
        while(!val.empty()){
        int temp = val.pop();
        if(temp <= min){
            min = temp;
        }
        }
        val.push(min);
    }
    else if(operator.equals("max")){
        while(!val.empty()){
        int temp = val.pop();
        if(temp >= max){
            max = temp;
        }
        }
        val.push(max);
    }
}

public int pop() throws RemoteException{
    return val.pop();
}

public boolean isEmpty() throws RemoteException{
    return val.empty();
}

public int delayPop(int millis) throws RemoteException{
    return millis;
}
}

