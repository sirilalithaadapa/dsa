
/*
Convert Infix to Prefix Expression
Objective: Given an Infix expression, write an algorithm to convert it into Prefix expression.
Algo rules:
=> Reverse the given Infix expression
=> If the character is operand, add to result.
=> If character is operator
    -> if stack is empty, push into stack
    -> else if stack is not empty
        - if the operator precedence is > top operator, push the 
          character to the operator stack
        - else "pop out an operator from the stack and add it to     result until stack is empty or top elements precedence is >, then push the operator"
=> If character is ')', then push
=> If the character is '(', then pop until ')' and add them to output and pop '('
=> once the expression is ended pop all the operators from stack and append to result
*/

// Ex: input: (a-b/c)*(a/k-l)   output: *-a/bc-/akl

import java.util.Scanner;
import java.util.Stack;

class InfixToPrefix {

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

    public static String infixToPrefix(String infix) {
        String prefix = "";
        Stack<Character> operators = new Stack<>();

        for (int i = infix.length() - 1; i >= 0; --i) {
            char ch = infix.charAt(i);

            if (precedence(ch) > 0) {
                while (operators.isEmpty() == false &&  precedence(operators.peek()) > precedence(ch)) {
                    prefix += operators.pop();
                }
                operators.push(ch);
            } else if (ch == '(') {

                char x = operators.pop();
                while (x != ')') {
                    prefix += x;
                    x = operators.pop();
                }

            } else if (ch == ')') {
                operators.push(ch);
            } else {
                prefix += ch;
            }
            System.out.println(prefix);
        }

        while (!operators.isEmpty()) {
            prefix += operators.pop();
        }

        String reversedPrefix = "";
        for (int i = prefix.length() - 1; i >= 0; i--) {
            reversedPrefix += prefix.charAt(i);
        }
        return reversedPrefix;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String infixExpression = in.next();
        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println(prefixExpression);
    }
}
