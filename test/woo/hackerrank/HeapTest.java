package woo.hackerrank;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static woo.hackerrank.HeapAddDeletePrintMin.*;

/**
 * Created by Łukasz on 2017-05-25.
 */
public class HeapTest {

    private Heap heap;

    @Before
    public void setUp() throws Exception {
        heap = new Heap(1000);
    }

    @Test
    public void runCasesFromFiles() throws Exception {
        File[] testCases = new File("test\\resources").listFiles((f, n) -> n.contains("Heap") && !n.contains("_"));
        for (File tc : testCases) {
            System.out.println("Running " + tc.getName() + "...");
            File output = new File("test\\resources\\" + tc.getName() + "_testOutput");
            Scanner scan = new Scanner(tc);
            int n = scan.nextInt();
            Heap h = new Heap(n);
            PrintStream out = System.out;
            System.setOut(new PrintStream(output));
            for(int i = 0; i < n; i++)
                switch(scan.nextInt()) {
                    case 1: h.add(scan.nextInt());
                        break;
                    case 2: h.delete(scan.nextInt());
                        break;
                    case 3: h.printMin();
                        break;
                }
            System.setOut(out);
            assertEquals(output.length(), new File("test\\resources\\" + tc.getName() + "_expectedOutput").length());
        }
    }
}