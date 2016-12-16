package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import calculator.Lexer2.Token;

public class TestingRegex {
	static ArrayList<Token> tokenOutput;
	 public static ArrayList<Token> lexertry(String input){
	 ArrayList<Pattern> myRegexes = new ArrayList<Pattern>();
	 ArrayList<Token> myTokens = new ArrayList<>();
	 
		Token a = new Token(null);
	 
    	String slparen = ".*\\(.*";
    	String srparen = ".*\\).*";
    	String snumber = ".*\\d+(?:\\.\\d+)?.*";
    	String sinch = ".*i.*";
    	String spoint = ".*\\p.*";
    	String splus = ".*\\+.*";
    	String sminus = ".*\\-.*";
    	String stimes = ".*\\*.*";
    	String sdivide = ".*/.*";
	 
	   	Pattern lparen = Pattern.compile(slparen);
	   	Pattern rparen = Pattern.compile(srparen);
	   	Pattern number = Pattern.compile(snumber);
	   	Pattern inch = Pattern.compile(sinch);
	   	Pattern point = Pattern.compile(spoint);
	   	Pattern plus = Pattern.compile(splus);
	   	Pattern minus = Pattern.compile(sminus);
	   	Pattern times = Pattern.compile(stimes);
	   	Pattern divide = Pattern.compile(sdivide);
   	 	
	   	myRegexes.add(lparen);
	   	myRegexes.add(rparen);
	   	myRegexes.add(number);
	   	myRegexes.add(inch);
	   	myRegexes.add(point);
	   	myRegexes.add(plus);
	   	myRegexes.add(minus);
	   	myRegexes.add(times);
	   	myRegexes.add(divide);
	   
	   	String[] inputArray = input.split("");
	   	for (String s: inputArray){
	   		for (Pattern rx : myRegexes){
		   		if (rx.matcher(s).find()){
		   			if(rx.equals(lparen))
		   				a.type=Type.L_PAREN;
		   			if(rx.equals(rparen))
		   				a.type=Type.R_PAREN;
		   			if(rx.equals(number))
		   				a.type=Type.NUMBER;
		   			if(rx.equals(inch))
		   				a.type=Type.INCH;
		   			if(rx.equals(point))
		   				a.type=Type.POINT;
		   			if(rx.equals(plus))
		   				a.type=Type.PLUS;
		   			if(rx.equals(minus))
		   				a.type=Type.MINUS;
		   			if(rx.equals(times))
		   				a.type=Type.TIMES;
		   			if(rx.equals(divide))
		   				a.type=Type.DIVIDE;
		   			a.text = s;
		   		myTokens.add(a); 
		   		}
	   		}
	   	}tokenOutput = myTokens;
	   	return tokenOutput;
    }
 
public static class TestRegex {
    public static void main(String[] args) {
    	Lexer2 lexer = new Lexer2("(45454)");
    	ArrayList<Token> x = lexer.tokenOutput;
    	for (int i = 0; i<x.size(); i++){
//
    	}
    	}
    }

	 
	 public static boolean parsertry(ArrayList<Token> myRegexes){
		 @SuppressWarnings("unchecked")
		 ArrayList<Token> parenRegexes = new ArrayList<>();
		 for (Token a: myRegexes){
			 if (a.type == Type.L_PAREN){ //extract all tokens in between parens
				 while (myRegexes.iterator().next().type != Type.R_PAREN){
					 parenRegexes.add(myRegexes.iterator().next());
				 }
			 }
			 //check in the calculation branch
//			 if (a.type == Type.R_PAREN){ 
//				 if (myRegexes.get(myRegexes.indexOf(a)+1).type == Type.INCH ){
//					 
//				 }
//			 }
			 if (a.type == Type.INCH){
		 		if (myRegexes.get(myRegexes.indexOf(a)-1).type == Type.NUMBER ){
		 			long value = (Long.parseLong(a.text)*72);
		 			a.text = String.valueOf(value);
		 		}
		 	}
		 }
		return false;
	 }
	 
	 
	 
}
