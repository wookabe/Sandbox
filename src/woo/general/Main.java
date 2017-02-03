package woo.general;

import woo.nbrdist.NumbersDistanceWithArrayAndThreads;
import woo.nbrdist.NumbersDistanceWithArrayNoSqrt;
import woo.nbrdist.NumbersDistanceWithArrayWithoutComputeDiff;
import woo.nbrdist.Point;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
//        executeSolutions(new BinaryGap(), (int) Math.pow(10, 6), (int) Math.pow(2, 30) + 1);
//        String pkgName = Main.class.getPackage().getName();
//        //URL pkgFolder = ClassLoader.getSystemClassLoader().getResources(pkgName).nextElement();
//        URI pkgFolder = Thread.currentThread().getContextClassLoader().getResource(pkgName).toURI();
//        File[] folderFiles = new File(pkgFolder).listFiles(f -> !f.getName().contains("Main"));
//        Arrays.stream(folderFiles).
//                map(String::valueOf).
//                map(f -> f.substring(f.lastIndexOf(pkgName)).
//                        replaceAll(".class", "").
//                        replaceAll("\\\\", ".")).
//                map(throwRuntime(Class::forName)).
//                map(throwRuntime(Class::newInstance)).
//                forEach(o -> executeSolutions(o, (int) Math.pow(10, 9), (int) Math.pow(2, 30) + 1));

//        --------------------------------------------------------------------------------------------------------

//        executeSolutions(new BinaryGap(), (int) Math.pow(10, 6), (int) Math.pow(2, 30) + 1);

//        --------------------------------------------------------------------------------------------------------

//        int[] A = new int[(int) Math.pow(10, 6)];
//        Arrays.setAll(A, i -> ++i);
//        System.out.println(Arrays.toString(A));
//        executeSolutions(new CyclingRotation(), (int) Math.pow(10, 1), A, 543);
//        System.out.println(Arrays.toString(A));

//        --------------------------------------------------------------------------------------------------------

//        int[] A = {123, 4, 3, 5, 3, 4, 1111, 5, 1, 2, 3, 4, 1, 2, 3, 4, 5, 5, 123};
//        int[] A = new int [(int) Math.pow(10,7) - 1];
//        Arrays.setAll(A, i -> i / 2);
//        System.out.println(Arrays.toString(A));
//        executeSolutions(new OddOccurencesInArray(), (int) Math.pow(10, 0), A);
//        System.out.println(Arrays.toString(A));

//        --------------------------------------------------------------------------------------------------------

//        int[] A = {3, 1, 2, 4, 3, 4, 5, 2, 2, 4, 5, 5, 2, 3, 2, 4, 2};
//        int[] A = new int[(int) Math.pow(10, 3)];
//        Random random = new Random();
//        Arrays.setAll(A, i -> random.nextInt(10));
//        System.out.println(Arrays.toString(A));
//        executeSolutions(new TapeEquilibrium(), (int) Math.pow(10, 6), A);
//        System.out.println(Arrays.toString(A));
//
//        --------------------------------------------------------------------------------------------------------

//        System.out.println("Thread to be created...");
//
//        Thread t = new Thread(() -> {
//            int msgCounter = 0;
//            while (true) {
//                System.out.format("Message nbr %s: %s\n", ++msgCounter, Math.random());
//                if (Thread.interrupted()) {
//                    System.out.println("Got interrupted... bye, bye");
//                    return;
//                }
//            }
//
//        });
//        t.start();
//
//        System.out.println("Thread created, now waiting...");
//        Thread.sleep(2000);
//
//        System.out.println("About to interrupt...");
//        t.interrupt();

//        --------------------------------------------------------------------------------------------------------

//        executeSolutions(new FrogJmp(), (int) Math.pow(10, 0), 10, 1200, 100);

//        --------------------------------------------------------------------------------------------------------

//        int[] A = {1, 2, 3, 10, 6, 8, 9, 4, 5};
//        int size = (int) Math.pow(10, 6);
//        int[] A = new int[size];
//        Arrays.setAll(A, i -> ++i);
//        System.out.println("A[100] = " + A[100] + ", A[1000000-1] = " + A[size - 1]);
//        A[100] = A[size - 1];
//        A[size - 1] = A[size - 1] + 1;
//        System.out.println("A[100] = " + A[100] + ", A[1000000-1] = " + A[size - 1]);
//        System.out.println(Arrays.toString(A));
//        executeSolutions(new PermMissingElem(), (int) Math.pow(10, 3), A);
//        System.out.println(Arrays.toString(A));

//        --------------------------------------------------------------------------------------------------------

//        System.out.println("Path: " + Paths.get("").toAbsolutePath());
//        System.out.println("Path: " + System.getProperty("user.dir"));

//        --------------------------------------------------------------------------------------------------------

//        NumbersDistanceWithArrayAndThreads numberDistance = new NumbersDistanceWithArrayAndThreads("points");
//        log(Arrays.toString(numberDistance.
//                computeClosestTo(new Point(-200, 300), 10)));
//        log(Arrays.toString(numberDistance.
//                computeFurthestTo(new Point(1000, 25), 10)));
//
//        --------------------------------------------------------------------------------------------------------

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            System.out.println(scanner.next());
//        }
//
//        Files.readAllBytes(Paths.get("path/to/file"));


//        List<String> v = new ArrayList();
//
//        for (int i = 0; i < 10; i++)
//            v.add(String.valueOf(i));
//
//        log(v);
//
//        v.removeIf(s -> true);
//
//        log(v);
//
//
//        for (int i = 0; i < 10; i++)
//            v.add(String.valueOf(i));
//
//        log(v);
//
//
//        for(String s : v) {
//            log(s);
//            v.iterator().remove();
//        }
//
//        log(v);

        int numProd = 15;
        int numCons = 15;

        Random r = new Random();
        BlockingQueue<Long> q = new ArrayBlockingQueue(100);

        for (int i = 0; i < numProd; i++) {
            new Thread(() -> {
                while (true)
                    try {
                        Thread.sleep(r.nextInt(1000));
                        final long time = System.currentTimeMillis() % 10000;
                        q.put(time);
                        logDots(q.size());
//                        log("Put " + time);
//                        log("Kolejka: " + q);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }).start();
        }

        for (int i = 0; i < numCons; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(r.nextInt(1000));
                        long taken = q.take();
                        logDots(q.size());
//                        log("Taken " + taken);
//                        log("Kolejka: " + q);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

    private static synchronized void logDots(int count) {
        for (int i = 0; i < count; i ++)
            System.out.print(".");
        System.out.println();
    }

    @FunctionalInterface
    interface FunctionWithExceptions<T, R, E extends Exception> {
        R apply(T t) throws E;

    }

    public static <T, R, E extends Exception> Function<T, R> throwRuntime(FunctionWithExceptions<T, R, E> f) {
        return t -> {
            try {
                return f.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void executeSolutions(Object o, int nbrOfRuns, Object... params) {
        System.out.println("\nExecuting solutions from " + o.getClass());
        Arrays.stream(o.getClass().getMethods()).
                filter(m -> m.getName().startsWith("solution")).
                sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).
                forEach(m -> {
                    System.out.print("running " + m.getName() + "... ");
                    boolean firstRun = true;
                    Object result;
                    long time = System.nanoTime();
                    for (int i = 0; i < nbrOfRuns; i++) {
                        try {
                            result = m.invoke(o, params);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        if (firstRun) {
                            System.out.print("\tfirst result: " + result);
                            firstRun = false;
                        }
                    }
                    long timeAfter = System.nanoTime();
                    System.out.println(String.format("\ttime spent: %.3fs", (timeAfter - time) / 1000.0 / 1000.0 / 1000.0));
                });
    }

    private static long millis = 0;
    private static long millisStart = 0;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tc] %5$s %n");
    }

    public static void log(Object o) {
        synchronized (System.out) {
            long time = millis == 0 ? 0 : System.currentTimeMillis() - millis;
            if (millisStart == 0) millisStart = System.currentTimeMillis();
            System.out.println("Time since beginning: " + (System.currentTimeMillis() - millisStart) + " " +
                    String.format("[%-10s] [%.3f] [%s] %s",
                    Thread.currentThread().getName(),
                    time / 1000.0,
                    Thread.currentThread().getStackTrace()[2].getMethodName(),
                    o.toString()));
            System.out.flush();
            millis = System.currentTimeMillis();
        }
    }
}
