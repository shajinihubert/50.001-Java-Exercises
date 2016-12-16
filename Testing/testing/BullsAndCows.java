package testing;

public class BullsAndCows {
	   public static void main(String[] args) {
		   int x = count_bull_cows(0x1234,0x1321);
		   System.out.print("ans="+x);
	   }
		   
	   public static int count_bull_cows(int a, int b){	//a can be the secret number, and b can be any one of our guesses
			   int bulls;
			   int cows;
			   int i, j, btemp, atry, btry, mask;
			   bulls=0;
			   mask=0xF;								//1111, 1111 0000, 1111 0000 0000, 
			   											//1111 0000 0000 0000 (mask value in each iteration)
			   for (i=0;i<4;i=i+1){
				   if ((a&mask)==(b&mask)){				//checks if a-bits are equal to b-bits in the 
					   										//range of the bits of mask that have 1s
					   bulls = bulls+1;
					   a=a|mask; 						//puts all 1s in lower 4 bits of a and b 
					   									//(and puts 4 more bits with 1s with each iteration)
					   b=b|mask;
				   }
				   mask=mask<<4;
				  
			   }
			   
			   cows=0;
			   for (i=0;i<4;i=i+1){						//iterating each digit (digit = 4 bits) in a word (4 digits)
				   atry = a&0xF;						//original value of a
				   a=a>>4;								//similar to shifting mask<<4: aaaa aaaa aaaa aaaa, 
			   												//aaaa aaaa aaaa, aaaa aaaa, aaaa with each iteration
				   if(atry!=0xF){						//stops iterating when a has been shifted to 0 bits; 
					   									//atry = 0 & 1111 = 1111
					   btemp=b;							//restore value of btemp to be original b
					   mask=0xF;						//mask is redefined here, to be 1111 in each iteration 
					   										//of checking digits (digit = 4 bits)
					   for(j=0;j<4;j=j+1){				//iterating each bit (4 bits per digit) in each digit 
						   								//(4 digits in a and 4 digits in b)
						   btry=btemp&0xF;				//iterating across each digit of b
						   btemp=btemp>>4;
					   	   if (btry==atry){				//checking each bit of b (till all 16 bits 
					   		   							//of b are checked) with the same 4 bits of a
							   cows=cows+1;
							   b=b|mask;				//puts all 1s in lower 4 bits of b (and puts 4 more 
							   							//bits with 1s with each digit iteration)
							   break;
					   }								
					   	   mask=mask<<4;				//mask is shifted here, for checking next 4 digits
					   }
				   }
			   }
			   return (bulls<<4)+cows; 
	   		}
}
