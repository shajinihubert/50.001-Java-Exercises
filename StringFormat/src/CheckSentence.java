public class CheckSentence {
    public static String chkSentence(String input) {
    	char[] inputArray = input.toCharArray();
    	if (input.contains("s")){
    		int prev_char = input.indexOf("s") - 1;
    		int next_char = input.indexOf("s") + 1;
    		if ((inputArray[next_char] == ' ' && (inputArray[prev_char] == '?' || inputArray[prev_char] == '-')) || (inputArray[inputArray.length - 1] == '?' || inputArray[inputArray.length - 1] == '-')){
    				return ("Found bad Sentence: ");
    			}
    		} 
    		return ("Found good Sentence: ");
    }
}
