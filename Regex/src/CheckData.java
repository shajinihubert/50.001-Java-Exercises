import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckData {
    public static String chkData (String inp) {

	String patternString = "(\\d\\d:\\d\\d:\\d\\d) ([0-3]\\d-[01]\\d-\\d{4}) (SpO2|Resp|HR|ABP)";
	 Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
     Matcher matcher = pattern.matcher(inp);
     if (matcher.find()){
    	 return "No Error";
     }
     return "Error";


    }
}
