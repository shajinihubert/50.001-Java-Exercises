

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations {
	public static List<List<String>> listPermutations(List<String> pathCombinations) {
	    if (pathCombinations.size() == 0) {
	        List<List<String>> result = new ArrayList<List<String>>();
	        result.add(new ArrayList<String>());
	        return result;
	    }
	    List<List<String>> returnMe = new ArrayList<List<String>>();
	    String firstElement = pathCombinations.remove(0);
	    List<List<String>> recursiveReturn = listPermutations(pathCombinations);
	    for (List<String> li : recursiveReturn) {
	        for (int index = 0; index <= li.size(); index++) {
	            List<String> temp = new ArrayList<String>(li);
	            temp.add(index, firstElement);
	            returnMe.add(temp);
	        }
	    }
	    return returnMe;
	}
	
	public static void main(String[] args){

	    List<String> intList = new ArrayList<String>(Arrays.asList("RWS","VIVO","SENTOSA"));
	    List<List<String>> myLists = listPermutations(intList);
	    List<String> output = new ArrayList<>();
	    Map<Integer, String> outputLists = new HashMap<>();
	    String rawAnswer = "Hotel-Zoo|Zoo-Resorts World Sentosa|Resorts World Sentosa-Buddha Tooth Relic Temple|Buddha Tooth Relic Temple-Hotel&=1";
	    List<String> answer = prepNodes(rawAnswer);
	    String value = prepValue(rawAnswer);
	    System.out.print(value);
	    
	    for (List<String> al : myLists) {
	    	al.add(0,"HOTEL");
	    	al.add("HOTEL");
	    	output.clear();
	    	for (int i=0; i<al.size()-1;i++){
	    		output.add(al.get(i)+al.get(i+1));
	    	}
	    	StringBuilder sb = new StringBuilder();
	    	for (String s : output){
	    	    sb.append(s);
	    	    if (output.indexOf(s) == (output.size()-1)){
	    	    	sb.append("\n");
	    	    }
	    	    else
	    	    	sb.append("-");
	    	}
	    	String st = sb.toString();
	    	outputLists.put(myLists.indexOf(al), st);
	    }

	    
	}
	
	public static int factorial(int num){
		int fact = 1;
		for(int j=1;j<=num;j++){    
		      fact=fact*j;    
		  }
		return fact;    
	}
	
	public static List<String> prepNodes(String rawAnswer){
		String[] rawConvertList = rawAnswer.split("\\|");
		List<String> rawList = new ArrayList<String>(Arrays.asList(rawConvertList));
		List<String> finalList = new ArrayList<String>();
		rawList.remove(0);
		for (String s:rawList){
			String[] eachElement = s.split("-");
			List<String> eachElementList = new ArrayList<String>(Arrays.asList(eachElement));
			String x = eachElementList.get(0);
			finalList.add(x);
		}
		return finalList;
	}
	
	public static String prepValue(String rawAnswer){
		rawAnswer = rawAnswer.replaceAll("\\D+","");
		return rawAnswer;
	}
	
}
