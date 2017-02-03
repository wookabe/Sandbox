package woo.general;

import java.io.*;
import java.util.*;

/**
 * Created by Łukasz on 2016-12-22.
 */
public class Intervals {

    private static class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        return checkLeft(root.left, root.data) && checkRight(root.right, root.data);
    }


    boolean checkLeft(Node root, int data) {
    int a[] = new int[1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(a.length / 2 + a.length % 2,
                (i, j) -> i < j ? 1 : i == j ? 0 : -1);

        if (root == null)
            return true;
        if (root.data >= data) return false;
        return checkLeft(root.left, root.data)
                && checkRight(root.right, root.data)
                && checkLeft(root.left, data)
                && checkLeft(root.right, data);
    }

    boolean checkRight(Node root, int data) {
        if (root == null)
            return true;
        if (root.data <= data) return false;
        return checkLeft(root.left, root.data)
                && checkRight(root.right, root.data)
                && checkRight(root.left, data)
                && checkRight(root.right, data);
    }

    public static void main(String[] args) {
        boolean log = false;

        Scanner scan = new Scanner(System.in);

        int s = scan.nextInt();
        if (log) System.out.println(s);

        for (int i = 0; i < s; i++) {
            int n = scan.nextInt();
            if (log) System.out.println(n);

            List<Interval> intervalList = new LinkedList<>();


            for (int j = 0; j < n; j++) {
                int ai = scan.nextInt();
                if (log) System.out.println(ai);

                int bi = scan.nextInt();
                if (log) System.out.println(bi);

                Interval interval = new Interval(ai, bi);
                int count = 0;
                for (Interval listInt : intervalList) {
                    if (interval.overlaps(listInt)) {
                        count++;
                        if (count == 2)
                            break;
                    }
                }

                if (count < 2)
                    intervalList.add(interval);
            }

            System.out.println(intervalList.size());
        }
    }

    private static class Interval {
        int a;
        int b;

        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }

        boolean overlaps(Interval interval) {
            if (interval.a >= a && interval.a <= b
                    || interval.a < a && interval.b >= a)
                return true;
            else
                return false;

        }

        @Override
        public String toString() {
            return "Interval{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

}
