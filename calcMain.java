/**
 * InfixPostfixCalculator
 */
package i2pcalc;
/**
 * Main class which runs the entire code and cleans up expression
 * Author: SoporificDreamer
 */
public class calculator{

    /**
     * Removes all the extra spaces and cleans up the expression for use
     */
    public static String cleanExpression(String trimExpression) {
        String expr = trimExpression.trim();
        return expr.replaceAll("[^\\^\\*\\+\\-\\d/\\s]", "");

    }

    /**
     * Does the actual evaluation of the  postfix notation
     */
    public static void evaluatePostfix(String a) {

        String cleanedExpression = cleanExpression(a);

        linkedList<Double> stack = new linkedList<>();

        for (String token : cleanedExpression.split("\\s")) {
            Double tokenNumber = null;
            
            try {
                tokenNumber = Double.parseDouble(token);
                
            } catch (NumberFormatException e) {
                //System.out.println(e);
            }
            
            if (tokenNumber != null) {
                stack.push(Double.parseDouble(token + ""));
            }
            //Calculation for the multiplication operator
            else if (token.equals("*")) {
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand * secondOperand);
            }
            //Calculation for the division operator
            else if (token.equals("/")) {
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand / secondOperand);
            } 
            //Calculation for the addition operator
            else if (token.equals("+")) {
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand + secondOperand);
            } 
            //Calculation for the subtraction operator
            else if (token.equals("-")) {
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand - secondOperand);
            }
            //And if the operator is not in the calculator
            else {
                System.out.println("Error: Operator does not exit!");
                return;
            }
        }
        System.out.println("Final answer: " + stack.pop());
    }

    /**
     * Running method
     * @param args
     */
    public static void main(String[] args) {

        infixToPostfix iftpf = new infixToPostfix();
        iftpf.mainTrial();
        String infix = iftpf.testString;
        String postfix = iftpf.postfixA;
        System.out.println("Infix:   " + infix);
        String clean = cleanExpression(postfix);
        System.out.println("Postfix: " + clean);
        System.out.println("Evaluating the expression: ");
        evaluatePostfix(clean);
    }
}
