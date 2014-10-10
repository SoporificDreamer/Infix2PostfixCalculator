/**
 * InfixPostfixCalculator
 */
package i2pcalc
import java.util.*;
/**
 * Converts infix to postfix
 * Author: SoporificDreamer
 */
public class infixToPostfix {

    public String postfixA;
    public String testString;

    /**
     * Determines whether character is a operator or not
     */
    private boolean isOperator(char opr) {
        
        // Supports +, -, *, /, ( and ) only in this version
        return opr == '+' || opr == '-' || opr == '*' || opr == '/' || opr == '(' || opr == ')';

    }

    /**
     * Takes into account if there is a gap between numbers
     */
    private boolean isSpace(char space) {  // Tell whether c is a space.

        return (space == ' ');

    }

    /**
     * Checks for the BODMAS rule
     */
    private boolean lowerRule(char operator1, char operator2) {
        // According to BODMAS rule which of the operators should go first
        // operator1 and operator2 are assumed to be operator characters (+,-,*,/).

        switch (operator1) {

            case '+':
            case '-':
                return !(operator2 == '+' || operator2 == '-');

            case '*':
            case '/':
                return operator2 == '^' || operator2 == '(';

            case '^':
                return operator2 == '(';

            case '(':
                return true;
            //In case the operator doesnt exist     
            default:
                return false;
        }

    }

    /**
     * Does the actual conversion to postfix(or Reverse-Polish Notation) form
     * from infix
     *
     * @param infix
     * @return
     */
    public String convertToPostfix(String infix) {

        // the stack of operators
        Stack operatorStack = new Stack();  
        // the first character of a token
        char c;
        // String tokenizer for the input string
        StringTokenizer parser = new StringTokenizer(infix, "+-*/() ", true);
        StringBuilder postfix = new StringBuilder(infix.length());
        // Processes the tokens
        while (parser.hasMoreTokens()) {
            String token = parser.nextToken();
            // get the next token and let c be
            c = token.charAt(0);
            // the first character of this token
            if ((token.length() == 1) && isOperator(c)) {
                while (!operatorStack.empty() && !lowerRule(((String) operatorStack.peek()).charAt(0), c)) // Operator on the stack does not have lower precedence, so it goes before this one
                {
                    postfix.append(" ").append((String) operatorStack.pop());
                }
                if (c == ')') {
                    // Output the remaining operators in the brackets
                    String operator = (String) operatorStack.pop();
                    while (operator.charAt(0) != '(') {
                        postfix.append(" ").append(operator);
                        operator = (String) operatorStack.pop();
                    }
                } else {
                    // Pushes the operator onto the stack.
                    operatorStack.push(token);
                }
            } else if ((token.length() == 1) && isSpace(c)) {
                // Leave and move on if its a space
            } else {
                // Push this operator onto the stack and its is the operand
                postfix.append(" ").append(token);

            }

        }

        while (!operatorStack.empty()) {
            postfix.append(" ").append((String) operatorStack.pop());
        }

        // Returns the result
        return postfix.toString();

    }

    /**
     * Testing to see if it works and contains expression
     */
    public void mainTrial() {

        testString = "2 - 3 * (4 / 5 + 6) * ((7 - 8) / 9)";

        infixToPostfix converter = new infixToPostfix();

        postfixA = converter.convertToPostfix(testString);
    }

}
