import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.Stack;


// Implements Sorter method 
public class SorterImplementation extends UnicastRemoteObject implements Sorter{
    
    //Creates an empty stack to push and pop values
    public Stack <Integer> val;

    //Default constructor to throw RemoteException from its parent constructor
    SorterImplementation() throws RemoteException{
        super();
        this.val = new Stack<Integer>();
    }
    //Constructor to initialize the stack with the values
    public Stack <Integer> getVal() throws RemoteException{
        return this.val;
    }

//initialise and declare variables
int min = Integer.MAX_VALUE;
int max = Integer.MIN_VALUE;

//Method to push the values in the stack
public void pushValue(int value) throws RemoteException{
    val.push(value);
    System.out.println("Pushed: " + value);
}

//Method to sort the operators in ascending, descending, min, max
public void pushOperator(String operator) throws RemoteException{
    if(operator.equals("ascending")){
        Collections.sort(val);
        System.out.println("Sorted Ascending "+ val);
    }
    else if(operator.equals("descending")){
        Collections.sort(val);
        Collections.reverse(val);
        System.out.println("Sorted Descending " + val);
    }
    else if(operator.equals("min")){
        while(!val.empty()){
            int temp = val.pop();
            if(temp < min){
                min = temp;
            }
        }
        val.push(min);
        System.out.println("Minimum: " + min);
    }
    else if(operator.equals("max")){
        while(!val.empty()){
            int temp = val.pop();
            if(temp > max){
                max = temp;
            }
        }
        val.push(max);
        System.out.println("Maximum: " + max);
    }
}

//Method to pop the values from the stack
public int pop() throws RemoteException{
    int popValue = val.pop();
    System.out.println("Popped: " + popValue);
    return popValue;
}

//Method to check if the stack is empty
public boolean isEmpty() throws RemoteException{
    System.out.println("Stack is empty: " + val.empty());
    return val.empty();
}

//Method to delay the pop of the values from the stack
public int delayPop(int millis) throws RemoteException{
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    int delayPopValue = val.pop();
    System.out.println("Delay Value popped: " + delayPopValue + " with " + millis + " milliseconds");
    return delayPopValue;
}
}

