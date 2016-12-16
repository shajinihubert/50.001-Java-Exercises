
import java.util.InputMismatchException;
import java.util.Scanner;

public class ModularProgram {
	 public static void main(String[] args) {
	       Scanner scanner = new Scanner(System.in);
	       
	       boolean continuing = true;
	       
	       while(continuing == true){
	       try{
	       System.out.print("Enter 2 integer values:\n");
	       int input1 = scanner.nextInt();
	       int input2 = scanner.nextInt();
	       int value = input1%input2;
	       }
	       catch(ArithmeticException ex){
	    	   System.out.print("Sorry, cannot compute mod by 0\n");
	       }
	       catch (InputMismatchException ex){
	    	}
	       
	       System.out.print("Do another pair of values ? (Y/N)\n");
	       String continue_itr = scanner.next();
	       if (continue_itr.equals("y") == false  ){
	    	  continuing = false;
	       }//while
	     }
	 }
	 }
