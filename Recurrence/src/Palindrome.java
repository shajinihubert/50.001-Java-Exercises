import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome {
	public static boolean recurPalindrome(String strSubmitted){
		System.out.print(strSubmitted.charAt(0));
		System.out.print(strSubmitted.charAt(strSubmitted.length()-1));
		if (strSubmitted.length()<2){
			return true;
		}else if (strSubmitted.charAt(0)==strSubmitted.charAt(strSubmitted.length()-1)){
			String x = strSubmitted.substring(1, strSubmitted.length()-1);
			return recurPalindrome(x);
		}
		if(strSubmitted.charAt(0) != strSubmitted.charAt(strSubmitted.length()-1)){
			return false;
			}
		return false;
	}
	
	 	public static void main(String[] args){
	 		String[] wordlist = {"civic", "Singapore", "deified", "Technology", "Design"};
	 		for (int i = 0; i <wordlist.length; i ++){
	 			System.out.println("RecurPalinCheck:" + Palindrome.recurPalindrome(wordlist[i]));
	 		}
	 	}
	
	
}
