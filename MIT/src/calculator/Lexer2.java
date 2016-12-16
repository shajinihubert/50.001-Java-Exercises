package calculator;
 
import java.awt.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.Type;
import calculator.Lexer2.Token;
 
/**
 * Calculator lexical analyzer.
 */
public class Lexer2 {
    public static class Token {
        Type type;
        String text;
        
        
        Token(Type type, String text) {
            this.type = type;
            this.text = text;
        }
 
        Token(Type type) {
            this(type, null);
        }
    }
 
    @SuppressWarnings("serial")
    static class TokenMismatchException extends Exception {
    }
    
    ArrayList<Token> tokenOutput;
    
    public Lexer2(String input) {
//	 public static boolean hehe(String input){
		 ArrayList<Pattern> myRegexes = new ArrayList<Pattern>();
		 ArrayList<Token> myTokens = new ArrayList<>();
		 
			Token a = new Token(null);
		 
	    	String slparen = ".*\\(.*";
	    	String srparen = ".*\\).*";
	    	String snumber = ".*\\d+(?:\\.\\d+)?.*";
	    	String sinch = ".*i.*";
	    	String spoint = ".*\\.*";
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
	    }
	 
    public static class TestRegex {
	    public static void main(String[] args) {
	    	Lexer2 lexer = new Lexer2("(45454)");
	    	ArrayList<Token> x = lexer.tokenOutput;
		    System.out.println(x);
	    }
	}
    
}
    