package calculator;
 
import java.util.ArrayList;

import calculator.Lexer;
import calculator.Lexer.Token;
 
//input: long datatype
//operations: + - / *
//parsing: pt, in, ()

/**
 * Calculator parser. All values are measured in pt.
 */
class Parser2 {

	
    @SuppressWarnings("serial")
    static class ParserException extends RuntimeException {
    }
    private enum ValueType {
        POINTS, INCHES, SCALAR
    };
    public class Value {
        final double value;
        final ValueType type;
        Value(double value, ValueType type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public String toString() {
            switch (type) {
            case INCHES:
                return value / PT_PER_IN + " in";
            case POINTS:
                return value + " pt";
            default:
                return "" + value;
            }
        }
    } //value
 
    private static final double PT_PER_IN = 72;
    private final Lexer lexer;
    Parser2(Lexer lexer) {
    	this.lexer=lexer;
    	ArrayList<Token> myRegexes = lexer.tokenOutput;
		 for (Token a: myRegexes){
			 if (a.type == Type.L_PAREN){ //extract all tokens in between parens
				 while (myRegexes.iterator().next().type != Type.R_PAREN){
					 parenRegexes.add(myRegexes.iterator().next());
				 }
			 }
			 if (a.type == Type.INCH){
		 		if (myRegexes.get(myRegexes.indexOf(a)-1).type == Type.NUMBER ){
		 			long value = (Long.parseLong(a.text)*72);
		 			a.text = String.valueOf(value);
		 		}
		 	}
			 
		 }
	 }
    	
 
    public Value evaluate() {
    	ArrayList<Token> myRegexes = lexer.tokenOutput;
    	for (Token a: myRegexes){
    		if (a.type==Type.NUMBER && myRegexes.iterator().next().type){
    			a.text 
    		}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}