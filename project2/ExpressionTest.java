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


public class ExpressionTest {
    public static void main(String[] args) {
        System.out.println("Expression by A. Hakeem\n");
        for (String arg : args) {
            String[] infix = arg.split(" ");
            String[] postfix = Expression.convertToPostfix(infix);
            System.out.println(arg);
            System.out.print(" ".repeat(7));
            System.out.println(String.join(" ", postfix).replaceAll("[\\[\\],]", "") + " = " + Expression.evaluatePostfix(postfix) + "\n");
        }
    }
}
