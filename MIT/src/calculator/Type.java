package calculator;
 
// Arithmetic operations + - / *
// Order of importance ( ) >> */ >> +-
// Convert all input to long datatype
// input can have spaces between numbers/operations
// 1 inch = 72 points (direct multiplicative conversion) Thus,
	//convert all inches to points (if there is in & pt in same input)
//be able to catch exceptions in type mismatch + arithmetics (cannot divide by 0)
 

//GROUPINGS
//input: long datatype
//operations: + - / *
//parsing: pt, in, ()


/**
 * Token type.
 */
enum Type {
    L_PAREN,    // it means (
    R_PAREN,    // it means )
    NUMBER,     // 1, 2, 3, 4...
    INCH,       
    POINT,
    PLUS,       // +
    MINUS,      // -
    TIMES,      // *
    DIVIDE      // /
}