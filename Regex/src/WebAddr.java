import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebAddr{
    public static boolean webValidate (String input){
    	String patternString = "(http|https|ftp)://(www.|m.|).*.(com|edu|net)";
   	 	Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()){
       	 return true;
        }
        return false;
    }
    
    public static class Test {

	    public static void main(String[] args) {
	    boolean x = webValidate("http://www.google.com");
	    System.out.println(x);
	    	
	    }
	    }
    
    
}
