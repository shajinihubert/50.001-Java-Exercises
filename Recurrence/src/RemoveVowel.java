
public class RemoveVowel {
	public static String recurCountVowel(String s){
		String result;
		if (s.length()<1)
			return s;
		if(isVowel(s.charAt(0)))
			return result = recurCountVowel(s.substring(1));	
		else 
			return result = s.charAt(0) + recurCountVowel(s.substring(1));
		}
	 public static boolean isVowel(char c){
	        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
	                || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
		}
	
	public static void main(String[] args){
		System.out.println(recurCountVowel("It is said ..."));
		System.out.println(recurCountVowel(""));
		System.out.println(recurCountVowel("GCD"));
		System.out.println(recurCountVowel("Hello Java"));
	}
}
