import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNRIC {
public static String chkNRIC (String input) {
    	String patternString = "[S|T|F|G]\\d{7}[A-Z] \\d{4}";
    	char[] inputArray = input.toCharArray();
    	 Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
         Matcher matcher = pattern.matcher(input);
         if (matcher.find()){
        	 if (input.toString().startsWith("T") && (inputArray[1]!=inputArray[inputArray.length-2] && inputArray[2]!=inputArray[inputArray.length-1])){
        		
        		 return ("Error");
        	 }

        	 return ("No Error"); 
         	}
    				

         	return ("Error");

    }
}
