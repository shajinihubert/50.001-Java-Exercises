import java.util.ArrayList;

public class Palindrome {
    public static boolean isPalindrome (char[] S) {
    
	ArrayList<Character> prevList = new ArrayList<Character>();
    	ArrayList<Character> nextList = new ArrayList<Character>();
    	if (S.length%2==0){										//input is even
    		for (int i = 0 ; i < S.length/2 ; i++){
    			prevList.add(S[i]);
    			nextList.add(S[S.length-1-i]);
    			}
    		if (prevList.equals(nextList))	{
    			return true;
    			}
    	}
    	else if (S.length%2 !=0){								//input is odd
    		for (int i = 0 ; i < (S.length-1)/2 ; i++){
      			prevList.add(S[i]);
    			nextList.add(S[S.length-1-i]);
    			}    	
    		if (prevList.equals(nextList))	{
        		return true;
        		}
    	}
    	return false;






    }
}
