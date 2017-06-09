package woo.hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Łukasz on 2017-05-25.
 */
public class HeapAddDeletePrintMin {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Heap h = new Heap(n);

        for(int i = 0; i < n; i++)
            switch(scan.nextInt()) {
                case 1: h.add(scan.nextInt());
                    break;
                case 2: h.delete(scan.nextInt());
                    break;
                case 3: h.printMin();
                    break;
            }
    }

    static class Heap {
        private final int[] heap;
        private int lastIndex;

        public Heap(int capacity) {
            heap = new int[capacity];
            lastIndex = -1;
        }

        public void add(int v) {
            heap[++lastIndex] = v;
            siftUp();
        }

        private void siftUp() {
            int index = lastIndex;
            int value = heap[lastIndex];
            while (index > 0 && value < heap[parent(index)]) {
                heap[index] = heap[parent(index)];
                index = parent(index);
            }
            heap[index] = value;
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        public void delete(int v) {
            int vIndex = findIndex(v, 0);
            heap[vIndex] = heap[lastIndex];
            //heap[lastIndex--] = 0;
            siftDown(vIndex);
        }

        private int findIndex(int v, int startIndex) {
            while (startIndex <= lastIndex && heap[startIndex] != v)
                startIndex++;
            return startIndex;
        }

        private void siftDown(int currentIndex) {
            int currentValue = heap[currentIndex];

            int fcIndex = firstChild(currentIndex);
            int fcValue = (fcIndex <= lastIndex) ? heap[fcIndex] : Integer.MAX_VALUE;
            int scIndex = secondChild(currentIndex);
            int scValue = (scIndex <= lastIndex) ? heap[scIndex] : Integer.MAX_VALUE;
            if (fcValue <= scValue && currentValue > fcValue) {
                heap[currentIndex] = heap[fcIndex];
                heap[fcIndex] = currentValue;
                siftDown(fcIndex);
            } else if (currentValue > scValue) {
                heap[currentIndex] = heap[scIndex];
                heap[scIndex] = currentValue;
                siftDown(scIndex);
            }
        }

        private int firstChild(int index) {
            return index * 2 + 1;
        }

        private int secondChild(int index) {
            return index * 2 + 2;
        }

        public void printMin() {
            System.out.println(heap[0]);
        }
    }
}