package calculator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class MultiUnitCalculator {
    public String evaluate(String expression) {
        Lexer lexer = new Lexer(expression);
        Parser parser = new Parser(lexer);
        return parser.evaluate().toString();
    }
}
class Lexer {
    /**
     * Token in the stream.
     */
    public static class Token {
        final Type type;
        final String text;
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
        public TokenMismatchException(String s){
            super(s);
        }
    }
    
    private static final Map<String, Type> tokenmap;
    private int current;
    private String input;
    private Token nextval;
    
    static {
        HashMap<String, Type> buildmap = new HashMap<String, Type>();
        buildmap.put("(", Type.L_PAREN);
        buildmap.put(")", Type.R_PAREN);
        buildmap.put("in", Type.INCH);
        buildmap.put("pt", Type.POINT);
        buildmap.put("+", Type.PLUS);
        buildmap.put("-", Type.MINUS);
        buildmap.put("*", Type.TIMES);
        buildmap.put("/", Type.DIVIDE);
        buildmap.put("0", Type.NUMBER);
        buildmap.put("1", Type.NUMBER);
        buildmap.put("2", Type.NUMBER);
        buildmap.put("3", Type.NUMBER);
        buildmap.put("4", Type.NUMBER);
        buildmap.put("5", Type.NUMBER);
        buildmap.put("6", Type.NUMBER);
        buildmap.put("7", Type.NUMBER);
        buildmap.put("8", Type.NUMBER);
        buildmap.put("9", Type.NUMBER);
        buildmap.put(".", Type.NUMBER);
        tokenmap = Collections.unmodifiableMap(buildmap);
    }
    public Lexer(String input) {
        this.current = 0;
        this.input = input.trim();
    }
    
    private Token read_next() throws TokenMismatchException {
        String c = this.input.substring(this.current);
        Type t = null;
        String t_string = null;
        
        if (c.length() == 0){
            return null;
        }
        
        for (String str : tokenmap.keySet()){
            if ( c.startsWith(str) ){
                t = tokenmap.get(str);
                t_string = str;
            }
        }
        
        if (t==null){
            throw new TokenMismatchException("No token found at character:" + (this.current+1) );
        }
        
        // Read entire number
        if (t == Type.NUMBER){
            Matcher m = Pattern.compile("^(\\d*(\\.\\d+)?)").matcher(c);
            if (!m.find()){
                throw new TokenMismatchException("Number found but fails regex");
            }
            t_string = m.group(1);
        }
        
        this.current += t_string.length();
        // Skip whitespace
        Matcher m = Pattern.compile("^(\\s*)").matcher(this.input.substring(this.current));
        if (m.find()){
            this.current += m.group(1).length();
        }
        
        return new Token(t, t_string);
    }
    
    public Token next() throws TokenMismatchException {
        if (this.nextval == null){
            return read_next();
        }
        Token unbound = this.nextval;
        this.nextval = null;
        return unbound;
    }
    
    public Token lookahead() throws TokenMismatchException {
        if (this.nextval == null){
            this.nextval = read_next();
        }
        return this.nextval;
    }
}
class Parser {
    
    @SuppressWarnings("serial")
    static class ParserException extends RuntimeException {
        public ParserException(String s){
            super(s);
        }
        public ParserException(String s, Throwable e){
            super(s,e);
        }
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
            String val;
            switch (type) {
            case INCHES:
                val = String.format("%.2f" ,value/PT_PER_IN);
                if (val.substring(val.length()-1).equals("0")){
                    val = val.substring(0,val.length()-1);
                }
                return val + " in";
            case POINTS:
                val = String.format("%.2f" ,value);
                if (val.substring(val.length()-1).equals("0")){
                    val = val.substring(0,val.length()-1);
                }
                return val + " pt";
            default:
                val = String.format("%.2f" ,value);
                if (val.substring(val.length()-1).equals("0")){
                    val = val.substring(0,val.length()-1);
                }
                return val;
            }
        }
    }
    private static final double PT_PER_IN = 72;
    private final Lexer lexer;
    private static final List<Type> binary_operators = Arrays.asList(new Type[]{Type.PLUS, Type.MINUS, Type.TIMES, Type.DIVIDE});
    private static final List<Type> unary_operators = Arrays.asList(new Type[]{Type.INCH, Type.POINT});
    private ArrayDeque<Type> operatorStack;
    private ArrayDeque<Value> valueStack;
    Parser(Lexer lexer) {
        this.lexer = lexer;
    }
    public Value evaluate() {
        try {
            operatorStack = new ArrayDeque<Type>();
            valueStack = new ArrayDeque<Value>();
            Lexer.Token prev_token = new Lexer.Token(Type.L_PAREN, "START OF EXPR:");
            Lexer.Token t;
            while( (t = lexer.next()) != null ){
                if (t.type == Type.NUMBER){
                    if (prev_token.type == Type.R_PAREN){
                        throw new ParserException("e");
                    }
                    double value = Double.parseDouble(t.text);
                    ValueType unit = ValueType.SCALAR;
                    if ( lexer.lookahead() == null ){
                    } else if ( lexer.lookahead().type == Type.INCH ){
                        value = value * PT_PER_IN;
                        unit = ValueType.INCHES;
                        lexer.next();
                    } else if ( lexer.lookahead().type == Type.POINT ) {
                        unit = ValueType.POINTS;
                        lexer.next();
                    }
                    valueStack.push(new Value(value, unit));
            	}
                else if ( unary_operators.contains(t.type) ){
                    ValueType unit= ValueType.SCALAR;
                    if (t.type == Type.INCH){
                        unit = ValueType.INCHES;
                    } else if  (t.type == Type.POINT){
                        unit = ValueType.POINTS;
                    }
                    Value topvalue = valueStack.pop();
                    if (t.type == Type.INCH && topvalue.type == ValueType.SCALAR){
                        valueStack.push(new Value(topvalue.value*PT_PER_IN, unit));
                    } else {
                        valueStack.push(new Value(topvalue.value, unit));
                    }
                    
                } else if ( binary_operators.contains(t.type) ){
                    // check
                    if ( binary_operators.contains(prev_token.type) ){
                        throw new ParserException("e");
                    }
                    // add
                    Type cur_op = t.type;
                    Type prev_op = operatorStack.peek();
                    while ( !operatorStack.isEmpty() ){
                        if ( prev_op == Type.L_PAREN ){
                            // Everything has precedence over L_PAREN.
                            break;
                        } else if ( (cur_op==Type.TIMES || cur_op==Type.DIVIDE) && (prev_op == Type.PLUS || prev_op == Type.MINUS) ){
                            //Don't pop and apply prev_op if cur_op has precedence.
                            break;
                        } else{
                            applyBinOpFromStack();
                            prev_op = operatorStack.peek();
                        }
                    }
                    operatorStack.push(cur_op);
                } else if ( t.type == Type.L_PAREN ){
                    // check
                    if ( prev_token.type == Type.R_PAREN ){
                        throw new ParserException("e");
                    }
                    // add
                    operatorStack.push(t.type);
                } else if ( t.type == Type.R_PAREN ){
                    // check
                    if ( binary_operators.contains(prev_token.type) ){
                        throw new ParserException("e");
                    }
                    // add
                    Type prev_op = operatorStack.peek();
                    while ( prev_op != Type.L_PAREN ){
                        if (prev_op == null){
                            throw new ParserException("e");
                        }
                        applyBinOpFromStack();
                        prev_op = operatorStack.peek();
                    }
                    operatorStack.pop(); // pop that L_PAREN
                }
                
                prev_token = t;
            }
            
            while( !operatorStack.isEmpty() ){
                Type next_op = operatorStack.peek();
                if ( (next_op == Type.L_PAREN) || (next_op == Type.R_PAREN)){
                    throw new ParserException("e");
                }
                applyBinOpFromStack();
            }
            return valueStack.pop();
            
        } catch (Lexer.TokenMismatchException e) {
            e.printStackTrace();
            return new Value(0.0, ValueType.SCALAR);
        }
    }
    
    private void applyBinOpFromStack(){
        Type op=null;
        Value vRight=null;
        Value vLeft=null;
        try{
            op = operatorStack.pop();
            vRight = valueStack.pop();
            vLeft = valueStack.pop();
        } catch (java.util.NoSuchElementException e){
            throw new ParserException("e");
        }
        
        double newvalue;
        ValueType unit = ValueType.SCALAR;
        if (vLeft.type == ValueType.SCALAR){
            unit = vRight.type;
        } else {
            unit = vLeft.type;
        }
        switch(op){
            case PLUS:
                if (vLeft.type == ValueType.SCALAR && vRight.type == ValueType.INCHES){
                    newvalue = (vLeft.value*PT_PER_IN) + vRight.value;
                } else if (vLeft.type == ValueType.INCHES && vRight.type == ValueType.SCALAR){
                    newvalue = vLeft.value + (vRight.value*PT_PER_IN);
                } else {
                    newvalue = vLeft.value + vRight.value;
                }
                break;
                
            case MINUS:
                if (vLeft.type == ValueType.SCALAR && vRight.type == ValueType.INCHES){
                    newvalue = (vLeft.value*PT_PER_IN) - vRight.value;
                } else if (vLeft.type == ValueType.INCHES && vRight.type == ValueType.SCALAR){
                    newvalue = vLeft.value - (vRight.value*PT_PER_IN);
                } else {
                    newvalue = vLeft.value - vRight.value;
                }
                break;
                
            case TIMES:
                newvalue = vLeft.value * vRight.value;
                if (unit == ValueType.INCHES && vLeft.type != ValueType.SCALAR && vRight.type != ValueType.SCALAR){
                    newvalue = newvalue/ (PT_PER_IN); // Really inch^2, but divide by 1 inch automatically.
                }
                break;
                
            case DIVIDE:
                if (vLeft.type == ValueType.SCALAR && vRight.type == ValueType.INCHES){
                    newvalue = (vLeft.value*PT_PER_IN*PT_PER_IN) / vRight.value;
                } else {
                    newvalue = vLeft.value / vRight.value;
                }
                if (vLeft.type != ValueType.SCALAR && vRight.type != ValueType.SCALAR){ // Division has special units
                    unit = ValueType.SCALAR;
                }
                break;
                
            default:
                throw new ParserException("e");
        }
        valueStack.push( new Value(newvalue, unit));
    }
}
