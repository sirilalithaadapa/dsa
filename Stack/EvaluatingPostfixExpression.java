/*
Evaluating a postfix expressions
Rules:
1) Create a stack for operands
2) Scan through the postfix expression
    => If the element is a number, push it into the stack
    => If the element is a operator, pop operands from the stack and evaluate the operator and push the result backto the stack
3) When the expression is ended, the number in the stack is the final answer.
Sample input: 231*+9-  output: -4
*/

import java.util.Stack;
import java.util.Scanner;

class EvaluatingPostfixExpression {
    public static int result(char operator, int num1, int num2) {
        switch(operator) {
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '/':
                return num2 / num1;
            case '*':
                return num2 * num1;
            case '%':
                return num2 % num1;
            case '^':
                return num2 ^ num1;
        }
        return -1;
    }

    public static int evaluatePostfixExpression(String postfix) {
        Stack<Integer> operands = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            // check for number
            if (Character.isDigit(ch)) {
                operands.push(ch - '0');
            } else {
                int num1 = operands.pop();
                int num2 = operands.pop();
                operands.push(result(ch, num1, num2));
            }
        }

        return operands.pop();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String postfixExpression = in.next();
        System.out.println(evaluatePostfixExpression(postfixExpression));
    }
}
