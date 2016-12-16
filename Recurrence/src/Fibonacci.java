import java.util.ArrayList;

public class Fibonacci {
	static ArrayList<Integer> numList = new ArrayList<>();
	public static int recurFibonacci(int n){
		if(n == 0)
	       return 0;
	    else if(n == 1)
	      return 1;
	    else
	      return recurFibonacci(n - 1) + recurFibonacci(n - 2);
		}
	
	
	public static void main(String[] args){
		System.out.print(Fibonacci.recurFibonacci(3) + "\n");
		System.out.print(Fibonacci.recurFibonacci(5) + "\n");
		System.out.println(Fibonacci.recurFibonacci(10) + "\n");
	}
}
