package woo.towers;

import java.util.Stack;

/**
 * Created by Łukasz on 2017-01-20.
 */
class FancySolutionPrinter extends SolutionPrinter {
    private final static String MESSAGE = "Step %,4d ->  ";

    private String BASE = "";
    private String SPACE = "";

    private Stack<Integer> a = new Stack<>();
    private Stack<Integer> b = new Stack<>();
    private Stack<Integer> c = new Stack<>();
    private int step;

    @Override
    protected void reset(int nOfDisks) {
        a.clear();
        for (int i = nOfDisks; i > 0; i--)
            a.push(i);
        b.clear();
        c.clear();
        step = 0;
        SPACE = "";
        for (int i = 0; i < String.valueOf(nOfDisks).length(); i++) {
            SPACE += " ";
        }
        BASE = "";
        for (int i = 0; i < String.valueOf(nOfDisks).length(); i++) {
            BASE += "_";
        }
    }

    @Override
    protected void applyMove(Move m) {
        int elem = -1;
        switch (m.from) {
            case A:
                elem = a.pop();
                break;
            case B:
                elem = b.pop();
                break;
            case C:
                elem = c.pop();
                break;
        }
        switch (m.to) {
            case A:
                a.push(elem);
                break;
            case B:
                b.push(elem);
                break;
            case C:
                c.push(elem);
                break;
        }
        step++;
    }

    @Override
    protected void printState() {
        int level = Math.max(Math.max(a.size(), b.size()), c.size());
        while (level > 0) {
            new LevelPrinter(level--).print();
        }
        System.out.println();
    }

    private class LevelPrinter {
        private int level;

        public LevelPrinter(int level) {
            this.level = level;
        }

        private void print() {
            printMargin();
            printPole(a);
            printSpace();
            printPole(b);
            printSpace();
            printPole(c);
            System.out.println();
        }

        private void printMargin() {
            String message = String.format(MESSAGE, step);
            System.out.print(level > 1 ? message.replaceAll(".", " ") : message);
        }

        private void printPole(Stack<Integer> pole) {
            printSurround();
            printStick(pole);
            printSurround();
        }

        private void printSurround() {
            System.out.print(level > 1 ? SPACE : BASE);
        }

        private void printStick(Stack<Integer> pole) {
            String elem = "";
            if (level > 1 && level > pole.size()) elem = SPACE;
            else if (pole.size() > 0) {
                elem = pole.get(level - 1).toString();
                for (int i = 0; i < SPACE.length() - elem.length(); i++) {
                    elem = " " + elem;
                }
            } else elem = BASE;
            System.out.print(elem);
        }

        private void printSpace() {
            System.out.print(SPACE + SPACE);
        }
    }
}
