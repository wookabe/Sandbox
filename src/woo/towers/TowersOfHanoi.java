package woo.towers;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

import static woo.towers.Move.Pole;

/**
 * Created by Łukasz on 2017-01-20.
 */
class TowersOfHanoi {

    private SolutionPrinter solutionPrinter;

    TowersOfHanoi(SolutionPrinter solutionPrinter) {
        this.solutionPrinter = solutionPrinter;
    }

    void printSolution(int nOfDisks, Map<Integer, Move> solution) {
        solutionPrinter.print(nOfDisks, solution);
    }

    void printSolution(int nOfDisks, Map<Integer, Move> solution, long sleep) {
        solutionPrinter.print(nOfDisks, solution, sleep);
    }

    Map<Integer, Move> solve(int n) {
        Map<Integer, Move> solution = new ConcurrentSkipListMap<>();

        solve(n, Pole.A, Pole.C, Pole.B, solution);

        return solution;
    }

    private void solve(int n, Pole from, Pole to, Pole helper, Map<Integer, Move> solution) {
        if (n <= 0) return;

        if (n == 1) move(from, to, solution);
        else {
            solve(n - 1, from, helper, to, solution);
            move(from, to, solution);
            solve(n - 1, helper, to, from, solution);
        }
    }

    private Move move(Pole from, Pole to, Map<Integer, Move> solution) {
        return solution.put(solution.size() + 1, new Move(from, to));
    }

}
