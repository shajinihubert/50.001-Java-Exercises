public class CheckNumber {
    public static String chkNumber(String input) {
		if (input.matches("[+]?(65)? ?(6|8|9)\\d{3} ?\\d{4}")){
    				return ("Found good Tel no: ");
    			}
    		return ("Found bad Tel no: ");
    }
}