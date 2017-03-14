package woo.crackingTCI;

/**
 * Created by Łukasz on 2017-03-12.
 */
public class DecDoubleToBin {

    public String toBin(double d) {
        //validate(d);

        String result = "0.";

        double tmp = -1;
        for (int i = 1; i <= 31 && tmp != 1 && tmp != 0; i++) {
            if (i == 31) {
                System.out.println(result);
                result = "ERROR";
            }
            else {
                tmp = d * Math.pow(2, i);
                if (tmp >= 1) {
                    result += "1";
                    d -= Math.pow(2, -i);
                }
                else {
                    result += "0";
                }
            }
        }
        return result;
    }
}