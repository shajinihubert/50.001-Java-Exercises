
public class q1 {
	  public static String reverse(String str) {
		  System.out.println("input string ="+str);
		  String result;
		  String[] array = str.split(" ");
		  if (array.length<2){
			  return result = str;
		  }
		  else{
			  return result =reverse(str.substring(str.indexOf(' ')+1)) + " "+ array[0];
		  }
	  }
	  public static void main(String[] args){
		  System.out.println(reverse("man are fish"));
	  }
}
