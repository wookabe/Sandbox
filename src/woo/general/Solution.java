package woo.general;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int[] l1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            l1[i] = scan.nextInt();
        }
        int n2 = scan.nextInt();
        int[] l2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            l2[i] = scan.nextInt();
        }

        long start = l2[0];
        for (int i = 0; i < l1.length; i++) {
            if (l1[i] == start) {
                int index = 0;
                while (index + i < l1.length && index < l2.length) {
                    if (index == l2.length - 1) {
                        System.out.println(i);
                        return;
                    }
                    if (l1[index + i] != l2[index]) {
                        break;
                    }
                    index++;
                }
            }
        }


    }
}

