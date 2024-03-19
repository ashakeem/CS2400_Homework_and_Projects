//
// Name: Hakeem, Ayomide
// Project: #2
// Due: 19th March, 2024
// Course: cs-2400-03-sp24
//
// Description:
// This program takes in a list of infix expressions and converts 
// them to postfix expressions and evaluates them.
//

import java.util.*;

public class Expression {
    
    public static String[] convertToPostfix(String[] infixExpression) {
        Stack<String> stack = new Stack<>();
        List<String> postfix = new ArrayList<>();
        
        for (String token : infixExpression) {
            if (isNumber(token)) {
                postfix.add(token);
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && isOperator(stack.peek()) && precedence(token) <= precedence(stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                if (stack.isEmpty()) {
                    throw new RuntimeException("Mismatched parentheses");
                }
                stack.pop(); // pop the left parenthesis
            } else {
                throw new RuntimeException("Invalid token: " + token);
            }
        }
        
        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) {
                postfix.add(stack.pop());
            } else {
                throw new RuntimeException("Mismatched parentheses");
            }
        }
        
        return postfix.toArray(new String[0]);
    }
    
    public static double evaluatePostfix(String[] postfixExpression) {
        Stack<Double> stack = new Stack<>();
        
        for (String token : postfixExpression) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new RuntimeException("Missing operand");
                }
                double y = stack.pop();
                double x = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(x + y);
                        break;
                    case "-":
                        stack.push(x - y);
                        break;
                    case "*":
                        stack.push(x * y);
                        break;
                    case "/":
                        if (y == 0) {
                            throw new RuntimeException("Division by zero");
                        }
                        stack.push(x / y);
                        break;
                    case "^":
                        stack.push(Math.pow(x, y));
                        break;
                    default:
                        throw new RuntimeException("Invalid operator: " + token);
                }
            } else {
                throw new RuntimeException("Invalid token: " + token);
            }
        }
        
        if (stack.size() != 1) {
            throw new RuntimeException("Missing operator");
        }
        
        return stack.pop();
    }
    
    private static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("^");
    }
    
    private static int precedence(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;
        }
    }
}
