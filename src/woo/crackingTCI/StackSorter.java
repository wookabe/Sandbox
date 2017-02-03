package woo.crackingTCI;

import java.util.Stack;

/**
 * Created by Łukasz on 2017-01-31.
 * <p>
 * 3.6 Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items, but you may not copy the elements
 * into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
// if null or empty then return
// create stack2, initially empty
// create scalar buffer tmp
// operation 1: pop from stack1 to tmp
// operation 2: if peek on stack1 > tmp then pop from stack1 and push to stack2
// operation 3: else push tmp on stack2 and pop from stack1 to tmp
// if stack1 empty then push from tmp and then pop from stack2 and push to stack1 until stack2 empty
// success if no operation 2
// Q: what data is stored? Or generics?

public class StackSorter {
    public void sort(Stack<Integer> st) {
        if (st == null || st.isEmpty())
            return;

        Stack<Integer> tmpStack = new Stack<>();
        int tmp;
        boolean sorted;
        do {
            sorted = true;
            tmp = st.pop();
          //  System.out.print("tmp = " + tmp);
            while (!st.isEmpty()) {
                if (st.peek() > tmp) {
                    //System.out.print(", st.peek = " + st.peek() + " > tmp");
                    tmpStack.push(st.pop());
                    sorted = false;
                } else {
                    //System.out.print(", st.peek = " + st.peek() + " <= tmp");
                    tmpStack.push(tmp);
                    tmp = st.pop();
                }
            }
            st.push(tmp);
            while (!tmpStack.isEmpty()) {
                st.push(tmpStack.pop());
            }
            System.out.println();
        } while (!sorted);
    }
}