/*
Author:- Siri Lalitha Adapa
Convert Infix to Postix Expression
Objective: Given an Infix expression, write an algorithm to convert it into Postfix expression.
Algo rules:
=> If the character is operand, add to result.
=> If character is operator
    -> if stack is empty, push into stack
    -> else if stack is not empty
        - if the operator precedence is >= top operator, push the 
          character to the operator stack
        - else "pop out an operator from the stack and add it to     result until stack is empty or top elements precedence is >=, then push the operator"
=> If character is '(', then push
=> If the character is ')', then pop until '(' and add them to output and pop '('
=> once the expression is ended pop all the operators from stack and append to result
*/

// Ex: input: a+b*c/d%e^f/g+k-l^g    output: abc*d/ef^g/+k+lg^-

import java.util.Scanner;
import java.util.Stack;

class InfixToPostfix {

    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String infix) {
        String postfix = "";
        Stack<Character> operators = new Stack<>();

        for (char ch : infix.toCharArray()) {

            if (precedence(ch) > 0) {
                while (operators.isEmpty() == false &&  precedence(operators.peek()) >= precedence(ch)) {
                    postfix += operators.pop();
                }
                operators.push(ch);
            } else if (ch == ')') {

                char x = operators.pop();
                while (x != '(') {
                    postfix += x;
                    x = operators.pop();
                }

            } else if (ch == '(') {
                operators.push(ch);
            } else {
                postfix += ch;
            }
        }

        while (!operators.isEmpty()) {
            postfix += operators.pop();
        }
        return postfix;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String infixExpression = in.next();
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println(postfixExpression);
    }
}
