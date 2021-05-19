// Author :- Siri Lalitha Adapa
// Problem statement: https://www.hackerrank.com/challenges/balanced-brackets/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stk = new Stack<>();
        String OpenBrackets = "[{(";
        
        for(char c : s.toCharArray()) {
            if (OpenBrackets.contains(String.valueOf(c))) {
                stk.add(c);
            } else {
                if (stk.isEmpty()) return "NO";
                if ((c == ')' && stk.peek() == '(') || (c == ']' && stk.peek() == '[') || (c == '}' && stk.peek() == '{')) {
                    stk.pop();
                } else {
                    return "NO";
                }
            }
        }
        
        return stk.isEmpty() ? "YES" : "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
