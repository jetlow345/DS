import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.io.File;

public class SorterClient {
    SorterClient() {
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Sorter stub = (Sorter) registry.lookup("Sorter");

            try (
                    // Passing text file as a parameter
                    Scanner scan = new Scanner(new File(args[0]))) {
                //Keep reading lines from the file until there are no more lines        
                while (scan.hasNextLine()) {
                    try {
                        //(e.g. pushValue 10) Making sure 
                        String[] command = scan.nextLine().split(" ");
                        for (int i = 0; i < command.length; i++) {

                            //reading until find pushValue
                            if (command[i].equals("pushValue")) {
                                int value = Integer.parseInt(command[i + 1]);
                                stub.pushValue(value);
                                System.out.println("Value pushed: " + value);

                                // print the stack out of pushed value
                                System.out.println("Stack: " + stub.getVal());

                                // make a space between the output
                                System.out.println();

                            
                            } else if (command[i].equals("pushOperator")) {
                                String operator = command[i + 1];
                                stub.pushOperator(operator);
                                System.out.println("Operator: " + operator);

                                // print the stack out after the operation of ascending or descending or min or
                                // max
                                System.out.println("Stack: " + stub.getVal());

                                // make a space between the output
                                System.out.println();
                            } else if (command[i].equals("pop")) {
                                int value = stub.pop();
                                System.out.println("Value popped: " + value);

                                // print the stack out after popping
                                System.out.println("Stack: " + stub.getVal());

                                // make a space between the output
                                System.out.println();
                            } else if (command[i].equals("isEmpty")) {
                                boolean isEmpty = stub.isEmpty();

                                // print the stack out for true and false
                                System.out.println("Stack is empty: " + isEmpty);

                                // make a space between the output
                                System.out.println();

                            } else if (command[i].equals("delayPop")) {
                                int millis = Integer.parseInt(command[i + 1]);
                                int value = stub.delayPop(millis);
                                System.out.println("Value popped: " + value + " with " + millis + " milliseconds");

                                //print the stack out after delayPop
                                System.out.println("Stack: " + stub.getVal());

                                // make a space between the output
                                System.out.println();
                            }
                        }
                        // catch empty stack exception of isEmpty
                    } catch (EmptyStackException e) {
                        System.out.println();
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
