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
public class NumbersDistanceWithArrayNoSqrt {
    private final String filePath;

    public NumbersDistanceWithArrayNoSqrt(String filePath) {
        this.filePath = filePath;
    }

    public PointNoSqrt[] computeClosestTo(PointNoSqrt toPointNoSqrt, int howMany) throws IOException, InterruptedException {
        log("Entering with toPointNoSqrt=" + toPointNoSqrt + " and howMany=" + howMany);
        if (howMany <= 0)
            throw new IllegalArgumentException("Desired number of returned PointNoSqrts has to be greater than 0");

        PointNoSqrt[] result = takeFirstN(prepareData(toPointNoSqrt), howMany);
        log("Leaving");
        return result;
    }

    public PointNoSqrt[] computeFurthestTo(PointNoSqrt toPointNoSqrt, int howMany) throws IOException, InterruptedException {
        log("Entering with toPointNoSqrt=" + toPointNoSqrt + " and howMany=" + howMany);
        if (howMany <= 0) {
            throw new IllegalArgumentException("Desired number of returned PointNoSqrts has to be greater than 0");
        }

        PointNoSqrt[] result = takeLastN(prepareData(toPointNoSqrt), howMany);
        log("Leaving");
        return result;
    }

    private PointNoSqrt[] prepareData(PointNoSqrt toPointNoSqrt) throws IOException, InterruptedException {
        log("Entering with toPointNoSqrt=" + toPointNoSqrt);
        if (toPointNoSqrt == null)
            throw new IllegalArgumentException("Reference PointNoSqrt cannot be null");
        PointNoSqrt[] PointNoSqrts = readFile();
        computeDistances(toPointNoSqrt, PointNoSqrts);
        sortByDistance(PointNoSqrts);
        log("Leaving");
        return PointNoSqrts;
    }

    private void computeDistances(PointNoSqrt toPointNoSqrt, final PointNoSqrt[] PointNoSqrts) {
        log("Entering with toPointNoSqrt=" + toPointNoSqrt + " and PointNoSqrts[].length=" + PointNoSqrts.length);
        for (PointNoSqrt p : PointNoSqrts) {
            p.setDist(toPointNoSqrt);
        }
        log("Leaving");
    }

    private void sortByDistance(final PointNoSqrt[] PointNoSqrts) {
        log("Entering with PointNoSqrts[].length=" + PointNoSqrts.length);
        Arrays.sort(PointNoSqrts);
        log("Leaving");
    }

    private PointNoSqrt[] takeFirstN(final PointNoSqrt[] PointNoSqrts, final int howMany) {
        log("Entering with PointNoSqrts[].length=" + PointNoSqrts.length + " and howMany=" + howMany);
        if (howMany > PointNoSqrts.length)
            throw new IllegalArgumentException("howMany is greater then number of PointNoSqrts in the file");

        PointNoSqrt[] result = new PointNoSqrt[howMany];
        System.arraycopy(PointNoSqrts, 0, result, 0, howMany);
        log("Leaving");
        return result;
    }

    private PointNoSqrt[] takeLastN(final PointNoSqrt[] PointNoSqrts, final int howMany) {
        log("Entering with PointNoSqrts[].length=" + PointNoSqrts.length + " and howMany=" + howMany);
        if (howMany > PointNoSqrts.length)
            throw new IllegalArgumentException("howMany is greater then number of PointNoSqrts in the file");

        PointNoSqrt[] result = new PointNoSqrt[howMany];
        System.arraycopy(PointNoSqrts, PointNoSqrts.length - howMany, result, 0, howMany);
        log("Leaving");
        return result;
    }

    private PointNoSqrt[] readFile() throws IOException, InterruptedException {
        log("Entering with filePath=" + filePath);
        BufferedInputStream in = null;
        List<PointNoSqrt> resultList = new LinkedList<PointNoSqrt>();
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
                        resultList.add(new PointNoSqrt(lat, lon));
                    }
                }
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        log("Building array of PointNoSqrts from list...");
        PointNoSqrt[] resultArray = resultList.toArray(new PointNoSqrt[resultList.size()]);
        log("Leaving");
        return resultArray;
    }

}
