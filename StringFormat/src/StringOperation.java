import java.util.Arrays;
public class StringOperation {
	public static boolean isAllCharacterUnique(String sIn){
       for (char character : sIn.toCharArray()){
           if (sIn.indexOf(character) != sIn.lastIndexOf(character))
               return false;
       }
       return true;
	}
	
	public static boolean isPermutation(String sIn1, String sIn2){
 char[] s1 = sIn1.toCharArray();
       Arrays.sort(s1);
       String s1sorted = new String(s1);
       char[] s2 = sIn2.toCharArray();
       Arrays.sort(s2);
       String s2sorted = new String(s2);
           if (s1sorted.equals(s2sorted)) {
               return true;
           }
               return false;
   }
}