import java.util.*;

/**
 * @className: Bianlifeng
 * @description: TODO
 * @author: carl
 * @date: 2021/9/1 17:22
 */
public class Bianlifeng {

    /*static Set<Integer> goods;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] split = string.split(",");
        goods = new HashSet();

        for (int i = 0; i < split.length; i++) {
            int tmp = Integer.valueOf(split[i]);
            while (goods.contains(tmp)) {
                tmp++;
                result++;
            }
            goods.add(tmp);
        }
        System.out.println(result);
    }*/

    /*static int[] skuWeights;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        int boxCapacity = sc.nextInt();
        String[] split = string.split(",");
        skuWeights = new int[split.length];
        for (int i = 0; i < skuWeights.length; i++) {
            skuWeights[i] = Integer.valueOf(split[i]);
        }
        Arrays.sort(skuWeights);

        System.out.println(maxCount(skuWeights, boxCapacity));
    }

    static int maxCount(int[] weights, int capacity) {
        int result = 0;
        for (int i = 0; i < weights.length; i++) {
            if (capacity < weights[i]) {
                break;
            }
            capacity -= weights[i];
            result++;
        }
        return result;
    }*/

    static int row, column;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pStr = sc.nextLine();
        char[] chars = pStr.toCharArray();
        char remove = '[';
        for (int i = 0; i < chars.length; i++) {
            remove = (char) (remove + chars[i]);
        }
        remove = (char) (remove + ']');

        str.replace(remove, ' ');
        String[] array = str.split(";");

        String[] tmp = pStr.split(",");
        row = Integer.valueOf(tmp[0]);
        column = Integer.valueOf(tmp[1]);
    }

    static int getBestWay(int D_row, int D_column,
                          int DP_row, int DP_column,
                          int P_row, int P_column) {
        /*int row = D_row > DP_row ? Math.max(D_row, P_row) : Math.max(DP_row, P_row);
        int column = D_column > DP_column ? Math.max(D_column, P_column) : Math.max(DP_column, P_column);*/

        int result = 0;

        int rowSign = turnOrDown(row, D_row);
        int columnSign = turnOrDown(column, D_column);

        while (row != D_row && column != P_column) {
            if (Math.abs(row - D_row) > Math.abs(column - D_column)) {
                row += rowSign;
                result++;
            } else if (Math.abs(row - D_row) > Math.abs(column - D_column)) {
                column += columnSign;
                result++;
            } else {
                row += rowSign;
                column +=columnSign;
                result++;
            }
        }

        while (row != DP_row && column != DP_column) {
            if (Math.abs(row - DP_row) > Math.abs(column - DP_column)) {
                row += rowSign;
                result++;
            } else if (Math.abs(row - DP_row) > Math.abs(column - DP_column)) {
                column += columnSign;
                result++;
            } else {
                row += rowSign;
                column +=columnSign;
                result++;
            }
        }
        return result;
    }

    static int turnOrDown(int t1, int t2) {
        if (t1 > t2) {
            return -1;
        } else if (t1 < t2) {
            return 1;
        } else {
            return 0;
        }
    }
}
