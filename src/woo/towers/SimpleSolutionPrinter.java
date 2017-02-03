package woo.towers;

/**
 * Created by Łukasz on 2017-01-20.
 */
class SimpleSolutionPrinter extends SolutionPrinter {
    private int a;
    private int b;
    private int c;
    private int step;

    @Override
    protected void reset(int nOfDisks) {
        a = nOfDisks;
        b = 0;
        c = 0;
        step = 0;
    }

    @Override
    protected void applyMove(Move m) {
        switch (m.from) {
            case A:
                a--;
                break;
            case B:
                b--;
                break;
            case C:
                c--;
                break;
        }
        switch (m.to) {
            case A:
                a++;
                break;
            case B:
                b++;
                break;
            case C:
                c++;
                break;
        }
        step++;
    }

    @Override
protected void printState() {
    int level = Math.max(Math.max(a, b), c);
    while (level > 0) {
        new LevelPrinter(level--).print();
    }
    System.out.println();
}

private class LevelPrinter {
    final static String DISK = "()";
    final static String BASE = "__";
    final static String SPACE = "  ";
    final static String MESSAGE = "Step %,4d ->  ";

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

    private void printPole(int pole) {
        printSurround();
        printStick(pole);
        printSurround();
    }

    private void printSurround() {
        System.out.print(level > 1 ? SPACE : BASE);
    }

    private void printStick(int disksOnPole) {
        System.out.print(level - 1 >= disksOnPole ? SPACE
                : disksOnPole > 0 ? DISK
                : BASE);
    }

    private void printSpace() {
        System.out.print(SPACE + SPACE);
    }
}
}

