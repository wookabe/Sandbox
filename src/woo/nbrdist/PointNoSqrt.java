package woo.nbrdist;

/**
 * Created by Łukasz on 2016-10-17.
 */
public class PointNoSqrt implements Comparable<PointNoSqrt> {
    private final int lat;
    private final int lon;
    private Integer dist;

    public PointNoSqrt(int lat, int lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public int getLat() {
        return lat;
    }

    public int getLon() {
        return lon;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(PointNoSqrt p) {
        this.dist = Math.abs(lat - p.lat) + Math.abs(lon - p.lon);
    }

    @Override
    public int compareTo(PointNoSqrt o) {
        return dist.compareTo(o.dist);
    }

    @Override
    public String toString() {
        return String.format("Point{" +
                "lat=%s" +
                ", lon=%s" +
                ", dist=%.4f}", lat, lon, dist);
    }
}
