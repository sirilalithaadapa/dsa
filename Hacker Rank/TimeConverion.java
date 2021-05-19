// Author :- Siri Lalitha Adapa

// Problem statement: https://www.hackerrank.com/challenges/time-conversion/problem

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
         int len = s.length();
         String time = s.substring(len-2, len);
         String[] t = s.substring(0, len-2).split(":");
         
         int int_hrs = Integer.parseInt(t[0]);
         String mins = t[1];
         String secs = t[2];
         
         if (time.equals("PM") && int_hrs != 12) int_hrs += 12;
         if (time.equals("AM") && int_hrs == 12) int_hrs = 0;
         
         String hrs = String.valueOf(int_hrs);
         if (hrs.length() < 2) 
            hrs = "0" + hrs;

         return hrs + ":" + mins + ":" + secs;
         
         

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
