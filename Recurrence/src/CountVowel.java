
public class CountVowel {
	public static int recurCountVowel(String s){
        int result;
        if(s.length() == 0)
            result = 0;
        else {
            if(isVowel(s.charAt(0)))
                result = 1 + recurCountVowel(s.substring(1));
            else
                result = recurCountVowel(s.substring(1));
 
        }
        return result;
    }
 
    public static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
                || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
	}
	
	public static void main(String[] args){
		System.out.println(CountVowel.recurCountVowel("It is said ..."));
		System.out.println(CountVowel.recurCountVowel(""));
		System.out.println(CountVowel.recurCountVowel("GCD"));
		System.out.println(CountVowel.recurCountVowel("Hello Java"));
	}
	
}
