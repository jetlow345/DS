import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.io.File;
// import java.util.Stack;

public class SorterClient {
    private SorterClient(){}
    
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry(null);
            Sorter stub = (Sorter) registry.lookup("Sorter");
            // Scanner scan = new Scanner(new File(args[0]));
            stub.pushValue(1);
            System.out.println(stub.getStack());

            

            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            // if(args[i].equals("pushValue")){
                //     stub.pushValue(Integer.parseInt(args[i+1]));
                //     System.out.println("Pushed value: " + args[i+1]);
                // }
                // else if(args[i].equals("pushOperator")){
                //     stub.pushOperator(args[i]);
                //     System.out.println("Pushed operator: " + args[i+1]);
                // }
                // else if(args[i].equals("pop")){
                //     sorter.val.push(stub.pop());
                //     System.out.println("Popped value: " + stub.pop());
                // }
                // else if(args[i].equals("isEmpty")){
                //     System.out.println("isEmpty: " + stub.isEmpty());
                // }
                // else if(args[i].equals("delayPop")){
                //     System.out.println("delayPop: " + stub.delayPop(Integer.parseInt(args[i+1])));
                // }

            
        // do{
        //     System.out.println("1) Push Value");
        //     System.out.println("2) Push Operator");
        //     System.out.println("3) Pop");        
        //     System.out.println("4) Is Empty");
        //     System.out.println("5) Delay Pop");
        //     System.out.println("6) Exit");
        //     System.out.println();
        //     System.out.println("Enter your choice[1-6]: ");
        //     int choice = scan.nextInt();
            
        //     switch(choice){
        //         case 1: System.out.println("Enter value to push:");
        //                 int value = scan.nextInt();
        //                 sort.pushValue(value);
        //                 stub.pushValue(value);
        //                 System.out.println("Stack:" + sort.val);
        //                 break;

        //         case 2: System.out.println("Enter ascending, descending, min, max to set it:");
        //                 String operator = scan.next();
        //                 sort.pushOperator(operator);
        //                 stub.pushOperator(operator);
        //                 System.out.println("Stack:" + sort.val);
        //                 break;

        //         case 3: System.out.println("Value popped: " + sort.pop());
        //                 stub.pop();
        //                 System.out.println("Stack:" + sort.val);
        //                 break;

        //         case 4: System.out.println("Is stack empty: " + sort.isEmpty());
        //                 stub.isEmpty();
        //                 System.out.println("Stack:" + sort.val);
        //                 break; 
                
        //         case 5: System.out.println("Enter delay in millis:");
        //                 int millis = scan.nextInt();
        //                 System.out.println("Value popped: " + sort.delayPop(millis));
        //                 stub.delayPop(millis);
        //                 System.out.println("Stack:" + sort.val);
        //                 break;

        //         case 6: System.exit(0);break;
        //         default : System.out.println("Invalid value, Please enter again");     
        //     }
        //     System.out.println("\n");
            
        // }while(true);
            

        }catch(Exception e){
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
