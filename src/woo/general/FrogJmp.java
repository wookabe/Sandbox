package woo.general;

/**
 * Created by Łukasz on 2016-10-14.
 */
public class FrogJmp {
    public int solution(int X, int Y, int D) {
        int dist = Y - X;
        return dist / D + (dist % D == 0 ? 0 : 1);
    }
}
