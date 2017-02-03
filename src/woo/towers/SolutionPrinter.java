package woo.towers;

import java.util.Map;

/**
 * Created by Łukasz on 2017-01-20.
 */
abstract class SolutionPrinter {
    void print(int nOfDisks, Map<Integer, Move> solution) {
        print(nOfDisks, solution, 0);
    }

    void print(int nOfDisks, Map<Integer, Move> solution, long sleep) {
        reset(nOfDisks);
        System.out.println();
        printState();
        for (Move m : solution.values()) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            applyMove(m);
            printState();
        }
    }

    protected abstract void reset(int nOfDisks);

    protected abstract void applyMove(Move m);

    protected abstract void printState();
}
