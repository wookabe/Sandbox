package woo.hackerrank;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Łukasz on 2017-05-24.
 */
public class StackMaximumElement {
    private static Scanner scan;
    private static int nOptions;
    private static Stack stack;

    public static void main(String[] args) {
        initialize();
        run();
    }

    private static void initialize() {
        scan = new Scanner(System.in);
        nOptions = scan.nextInt();
        stack = new Stack(nOptions);
    }

    private static void run() {
        for (int i = 0; i < nOptions; i++)
            switch (scan.nextInt()) {
                case 1:
                    int e = scan.nextInt();
                    stack.add(e);
                    break;
                case 2:
                    stack.delete();
                    break;
                case 3:
                    stack.printMax();
                    break;
            }
    }

    private static class Stack {
        private static int[] stack;
        private static int topIndex;
        private static Queue<Integer> maxQueue;

        Stack(int capacity) {
            // capacity is the max number of stack elements but could use unbounded LinkedList instead
            stack = new int[capacity];
            topIndex = -1;
            maxQueue = new PriorityQueue<>(capacity, Collections.reverseOrder());
        }

        private void add(int e) {
            if (isFull())
                throw new RuntimeException("attempting to add to full stack");
            stack[++topIndex] = e;
            maxQueue.offer(e);
        }

        private void delete() {
            if (isEmpty())
                throw new RuntimeException("attempting to delete from empty stack");
            maxQueue.remove(stack[topIndex--]);
        }

        private void printMax() {
            if (isEmpty())
                print("No max value, stack is empty");
            print(maxQueue.peek());
        }

        private void print(Object o) {
            System.out.println(o);
        }

        private boolean isFull() {
            return topIndex == stack.length - 1;
        }

        private boolean isEmpty() {
            return topIndex < 0;
        }
    }
}
