package woo.nbrdist;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static woo.general.Main.log;

/**
 * Created by Łukasz on 2016-10-17.
 */
public class NumbersDistanceWithArray {
    private final String filePath;

    public NumbersDistanceWithArray(String filePath) {
        this.filePath = filePath;
    }

    public Point[] computeClosestTo(Point toPoint, int howMany) throws IOException, InterruptedException {
        log("Entering with toPoint=" + toPoint + " and howMany=" + howMany);
        if (howMany <= 0)
            throw new IllegalArgumentException("Desired number of returned Points has to be greater than 0");

        Point[] result = takeFirstN(prepareData(toPoint), howMany);
        log("Leaving");
        return result;
    }

    public Point[] computeFurthestTo(Point toPoint, int howMany) throws IOException, InterruptedException {
        log("Entering with toPoint=" + toPoint + " and howMany=" + howMany);
        if (howMany <= 0) {
            throw new IllegalArgumentException("Desired number of returned Points has to be greater than 0");
        }

        Point[] result = takeLastN(prepareData(toPoint), howMany);
        log("Leaving");
        return result;
    }

    private Point[] prepareData(Point toPoint) throws IOException, InterruptedException {
        log("Entering with toPoint=" + toPoint);
        if (toPoint == null)
            throw new IllegalArgumentException("Reference point cannot be null");
        Point[] points = readFile();
        computeDistances(toPoint, points);
        sortByDistance(points);
        log("Leaving");
        return points;
    }

    private void computeDistances(Point toPoint, final Point[] points) {
        log("Entering with toPoint=" + toPoint + " and points[].length=" + points.length);
        for (Point p : points) {
//            p.setDist(toPoint);
        }
        log("Leaving");
    }

    private void sortByDistance(final Point[] points) {
        log("Entering with points[].length=" + points.length);
        Arrays.sort(points);
        log("Leaving");
    }

    private Point[] takeFirstN(final Point[] points, final int howMany) {
        log("Entering with points[].length=" + points.length + " and howMany=" + howMany);
        if (howMany > points.length)
            throw new IllegalArgumentException("howMany is greater then number of points in the file");

        Point[] result = new Point[howMany];
        System.arraycopy(points, 0, result, 0, howMany);
        log("Leaving");
        return result;
    }

    private Point[] takeLastN(final Point[] points, final int howMany) {
        log("Entering with points[].length=" + points.length + " and howMany=" + howMany);
        if (howMany > points.length)
            throw new IllegalArgumentException("howMany is greater then number of points in the file");

        Point[] result = new Point[howMany];
        System.arraycopy(points, points.length - howMany, result, 0, howMany);
        log("Leaving");
        return result;
    }

    private Point[] readFile() throws IOException, InterruptedException {
        log("Entering with filePath=" + filePath);
        BufferedInputStream in = null;
        List<Point> resultList = new LinkedList<Point>();
        try {
            in = new BufferedInputStream(new FileInputStream(filePath));
            int b, b2 = 0;
            int lat = 0, lon = 0;
            for (int i = 1; (b = in.read()) != -1; i++) {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                if ((i % 2) == 1) { // reading first byte
                    b2 = (b << 8);
                } else { // reading second byte
                    b2 |= b;
                    if ((b2 >> 15) == 1) { // negative number
                        b2 |= 0xffff0000;
                    }
                    if ((i % 4) == 2) { // first two bytes constitute latitude
                        lat = b2;
                    } else if ((i % 4) == 0) { // second two bytes constitute longitude
                        lon = b2;
                        resultList.add(new Point(lat, lon));
                    }
                }
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        log("Building array of points from list...");
        Point[] resultArray = resultList.toArray(new Point[resultList.size()]);
        log("Leaving");
        return resultArray;
    }

}
