package woo.general;

/**
 * Created by Łukasz on 2017-01-07.
 */
public class Temp {

    public String concatenate(Object o1, Object o2) {
        return toNotNullString(o1) + toNotNullString(o2);
    }

    private String toNotNullString(Object o) {
        return o == null ? "" : o.toString();
    }
}
