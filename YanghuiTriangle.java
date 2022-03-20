import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: YanghuiTriangle
 * @description: 118.杨辉三角
 * @author: carl
 * @date: 2021/10/18 17:13
 */
public class YanghuiTriangle {
    public static void main(String[] args) {
        generate(5);
    }
    public static List<List<Integer>> generate(int numsRow) {
        List<List<Integer>> result = new ArrayList<>(Arrays.asList(Arrays.asList(1)));
        while (result.size() < numsRow) {
            List<Integer> current = new ArrayList<>();
            List<Integer> pre = new ArrayList(result.get(result.size() - 1));
            current.add(1);
            pre.add(0);
            for (int i = 1; i < pre.size(); i++) {
                current.add(pre.get(i-1)+pre.get(i));
            }
            result.add(current);
        }
        return result;
    }
}
