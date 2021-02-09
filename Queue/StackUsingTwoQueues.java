// Problem Statement: https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
1 x: Enqueue element x into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.
*/

public class StackUsingTwoQueues {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        Stack<Integer> stack_insert = new Stack<Integer>();
        Stack<Integer> stack_delete = new Stack<Integer>();
        
        int nQuery = input.nextInt();
        while (nQuery-- > 0) {
            int type = input.nextInt();
            
            if (type == 1) {
                int num = input.nextInt();
                stack_insert.push(num);
            }
            else if (type == 2) {
                if (stack_delete.isEmpty()) {
                    while(!stack_insert.isEmpty()) {
                        stack_delete.push(stack_insert.pop());
                    }
                } 
                stack_delete.pop();
            } else {
                if (stack_delete.isEmpty()) {
                    while(!stack_insert.isEmpty()) {
                        stack_delete.push(stack_insert.pop());
                    }
                }
                
                System.out.println(stack_delete.peek());
            }
        }
    }
}
