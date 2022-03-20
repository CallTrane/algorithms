import java.util.ArrayList;

/**
 * @className: YY
 * @description: TODO
 * @author: carl
 * @date: 2021/9/4 19:29
 */
public class YY {

    static double[] min;
    static double[] max;

    public ArrayList<Double> findPoints (double[] data) {

        if (data == null || data.length <= 0) {
            return null;
        }

        min = new double[data.length];
        max = new double[data.length];
        min[1] = data[0];
        max[data.length-2] = data[data.length-1];

        for (int i = 2; i < data.length - 1 ; i++) {
            min[i] = Math.max(min[i-2], data[i-1]);
        }

        for (int i = data.length - 3; i > 0; i--) {
            max[i] = Math.min(data[i+1], max[i+2]);
        }

        ArrayList<Double> result = new ArrayList();
        for (int i = 1; i < data.length - 1; i++) {
            if (min[i] < data[i] && data[i] < max[i]) {
                result.add(data[i]);
            }
        }
        return result;
    }
}
