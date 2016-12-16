public class PrimeNumberChecker{
	public static int isPrime(int num){
for(int i=2; i<=num/2; i++){
            	//System.out.println(i);
                if(num % i == 0){
                    return 0;              
                }
            }
            return 1;
        }
         

	}
