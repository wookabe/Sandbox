package woo.nbrdist;

/**
 * Created by Łukasz on 2016-10-17.
 */
public class Point implements Comparable<Point> {
    private final int lat;
    private final int lon;
    private double dist;

    public Point(int lat, int lon) {
        this.lat = lat;
        this.lon = lon;
        this.dist = 0;
    }

    public Point(byte[] points, int offset, Point toPoint) {
        lat = (points[0 + offset] << 8) | (points[1 + offset] & 0xff);
        lon = (points[2 + offset] << 8) | (points[3 + offset] & 0xff);
        this.dist = Math.sqrt(Math.pow(lat - toPoint.lat, 2) + Math.pow(lon - toPoint.lon, 2));
    }

    @Override
    public int compareTo(Point o) {
        return Double.compare(dist, o.dist);
    }

    @Override
    public String toString() {
        return String.format("Point{" +
                "lat=%s" +
                ", lon=%s" +
                ", dist=%.4f}", lat, lon, dist);
    }
}
