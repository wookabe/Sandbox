package woo.nbrdist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static woo.general.Main.log;

/**
 * Created by Łukasz on 2016-10-17.
 */
public class NumbersDistanceWithArrayAndThreads {
    //    private static final int FILE_READ_THREADS = 10;
//    private static final int FILE_READ_BUFFER_SIZE = 4 * 1000000;
    private final String filePath;
//    private final ExecutorService executor;
//    private final ReentrantLock fileReadLock = new ReentrantLock();

    public NumbersDistanceWithArrayAndThreads(String filePath) {
        this.filePath = filePath;
//        executor = Executors.newFixedThreadPool(FILE_READ_THREADS);
    }

    public Point[] computeClosestTo(Point toPoint, int howMany) throws IOException, InterruptedException {
        log("Entering with toPoint=" + toPoint + " and howMany=" + howMany);
        if (howMany <= 0)
            throw new IllegalArgumentException("Desired number of returned Points has to be greater than 0");

        byte[] points = readFile();
        Point[] result = findPoints(points, howMany, true, toPoint);

        log("Leaving");
        return result;
    }

    public Point[] computeFurthestTo(Point toPoint, int howMany) throws IOException, InterruptedException {
        log("Entering with toPoint=" + toPoint + " and howMany=" + howMany);
        if (howMany <= 0) {
            throw new IllegalArgumentException("Desired number of returned Points has to be greater than 0");
        }

        byte[] points = readFile();
        Point[] result = findPoints(points, howMany, false, toPoint);

        log("Leaving");
        return result;
    }

    private Point[] findPoints(byte[] points, int howMany, boolean closest, Point toPoint) {
        log("Entering with points[].length=" + points.length + ", howMany=" + howMany);

        Point[] resultArray = new Point[howMany];
        for (int i = 0; i < howMany; i++) {
            resultArray[i] = new Point(points, i * 4, toPoint);
        }
        if (closest)
            Arrays.sort(resultArray, Collections.reverseOrder());
        else
            Arrays.sort(resultArray);
        for (int i = 4 * howMany; i < points.length - 4; i+=4) {
            Point p = new Point(points, i, toPoint);
            if (p.compareTo(resultArray[0]) == (closest ? -1 : 1)) {
                resultArray[0] = p;
                if (closest)
                    Arrays.sort(resultArray, Collections.reverseOrder());
                else
                    Arrays.sort(resultArray);
            }
        }
        log("Leaving");
        return resultArray;
    }

    private byte[] readFile() throws IOException, InterruptedException {
        log("Entering with filePath=" + filePath);

        byte[] resultArray = Files.readAllBytes(Paths.get(filePath));

        log("Leaving");
        return resultArray;
    }

//    private Point[] readFileReturnPointArray() throws IOException, InterruptedException {
//        log("Entering with filePath=" + filePath);
//
//        byte[] b = Files.readAllBytes(Paths.get(filePath));
//        Point[] resultArray = new Point[b.length / 4];
//        int lat, lon;
//        for (int j = 0; j < b.length; j += 4) {
//            lat = (b[0 + j] << 8) | (b[1 + j] & 0xff);
//            lon = (b[2 + j] << 8) | (b[3 + j] & 0xff);
//            resultArray[j / 4] = new Point(lat, lon);
//        }
//
//        log("Leaving");
//        return resultArray;
//    }
//
//    private Point[] readFileByBlok() throws IOException, InterruptedException {
//        log("Entering with filePath=" + filePath);
//
//        Queue<Point> resultList = new LinkedBlockingQueue<>();
//
//        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath))) {
//            CountDownLatch latch = new CountDownLatch(FILE_READ_THREADS);
//            for (int i = 0; i < FILE_READ_THREADS; i++) {
//                executor.execute(() -> {
//                    log("In execute");
//                    byte[] b = new byte[FILE_READ_BUFFER_SIZE];
//                    int lat, lon;
//                    int readFlag = -1;
//                    do {
//                        try {
//                            fileReadLock.lock();
//                            readFlag = in.read(b);
//                        } catch (IOException e) {
//                            log(e.toString());
//                        } finally {
//                            fileReadLock.unlock();
//                        }
//                        if (readFlag != -1) {
////                            log("Read " + Arrays.toString(b));
//                            for (int j = 0; j < FILE_READ_BUFFER_SIZE; j += 4) {
//                                lat = (b[0 + j] << 8) | (b[1 + j] & 0xff);
//                                lon = (b[2 + j] << 8) | (b[3 + j] & 0xff);
//                                resultList.add(new Point(lat, lon));
//                            }
//                        }
//                        if (Thread.interrupted()) {
//                            break;
//                        }
//                    } while (readFlag != -1);
//                    latch.countDown();
//                    log("Leaving execute");
//                });
//            }
//            latch.await();
//            executor.shutdown();
//        }
//
//        log("Building array of points from list...");
//
//        Point[] resultArray = resultList.toArray(new Point[resultList.size()]);
//
//        log("Leaving");
//        return resultArray;
//    }
//
//    private Point[] readFileBy4Bytes() throws IOException, InterruptedException {
//        log("Entering with filePath=" + filePath);
//
//        Queue<Point> resultList = new LinkedBlockingQueue<>();
//
//        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath))) {
//            CountDownLatch latch = new CountDownLatch(FILE_READ_THREADS);
//            for (int i = 0; i < FILE_READ_THREADS; i++) {
//                executor.execute(() -> {
//                    log("In execute");
//                    List<Point> tmpList = new LinkedList<>();
//                    byte[] b = new byte[4];
//                    int lat, lon;
//                    int readFlag = -1;
//                    do {
//                        try {
//                            fileReadLock.lock();
//                            readFlag = in.read(b);
//                        } catch (IOException e) {
//                            log(e.toString());
//                        } finally {
//                            fileReadLock.unlock();
//                        }
//                        if (readFlag != -1) {
////                            log("Read " + Arrays.toString(b));
//                            lat = (b[0] << 8) | (b[1] & 0xff);
//                            lon = (b[2] << 8) | (b[3] & 0xff);
//                            tmpList.add(new Point(lat, lon));
//                        }
//                        if (Thread.interrupted()) {
//                            break;
//                        }
//                    } while (readFlag != -1);
//                    resultList.addAll(tmpList);
//                    latch.countDown();
//                    log("Leaving execute");
//                });
//            }
//            latch.await();
//            executor.shutdown();
//        }
//
//        log("Building array of points from list...");
//
//        Point[] resultArray = resultList.toArray(new Point[resultList.size()]);
//
//        log("Leaving");
//        return resultArray;
//    }

}
