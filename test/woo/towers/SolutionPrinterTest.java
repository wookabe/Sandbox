package woo.towers;

import org.junit.Test;

/**
 * Created by Łukasz on 2017-01-20.
 */
public class SolutionPrinterTest {
    @Test
    public void printSimple_4() throws Exception {
        TowersOfHanoi t = new TowersOfHanoi(new SimpleSolutionPrinter());
        int nOfDisks = 4;

        t.printSolution(nOfDisks, t.solve(nOfDisks));
    }

    @Test
    public void printFancy_4() throws Exception {
        TowersOfHanoi t = new TowersOfHanoi(new FancySolutionPrinter());
        int nOfDisks = 4;

        t.printSolution(nOfDisks, t.solve(nOfDisks));
    }

    @Test
    public void printFancy_10() throws Exception {
        TowersOfHanoi t = new TowersOfHanoi(new FancySolutionPrinter());
        int nOfDisks = 10;

        t.printSolution(nOfDisks, t.solve(nOfDisks));
    }

    @Test
    public void printFancy_3_andSleep_1s() throws Exception {
        TowersOfHanoi t = new TowersOfHanoi(new FancySolutionPrinter());
        int nOfDisks = 3;
        long sleep = 1000;

        t.printSolution(nOfDisks, t.solve(nOfDisks), sleep);
    }

    @Test
    public void printFancy_10_andSleep_1s() throws Exception {
        TowersOfHanoi t = new TowersOfHanoi(new FancySolutionPrinter());
        int nOfDisks = 10;
        long sleep = 1000;

        t.printSolution(nOfDisks, t.solve(nOfDisks), sleep);
    }
}