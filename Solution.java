import org.junit.Test;

import java.util.*;

/**
 * @className: Solution
 * @description: TODO
 * @author: carl
 * @date: 2021/8/24 19:54
 */
public class Solution {

    public int stringToInt(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        char[] strArray = str.toCharArray();
        int i = 0;
        int sign = 1;
        while (strArray[i] == ' ') {
            i++;
            if (i == strArray.length) {
                return 0;
            }
        }
        if (strArray[i] == '-') {
            sign = -1;
        }
        if (strArray[i] == '-' || strArray[i] == '+') {
            i++;
        }
        int result = 0;
        for (int j = i; j < strArray.length; j++) {
            if (strArray[j] < '0' || strArray[j] > '9') {
                break;
            }
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && strArray[j] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = (result * 10) + Integer.valueOf(strArray[j] - '0');
        }
        return sign * result;
    }

    public String multiply (String num1, String num2) {
        int n1 = stringToInt(num1);
        int n2 = stringToInt(num2);
        return String.valueOf(n1 * n2);
    }


    int cost, profit;
    public int maxProfit (int k, int[] prices, int fee) {

        int count = k;
        cost = Integer.MAX_VALUE;
        profit = 0;

        int tmp;
        for (int i = 0; i < prices.length; i++) {

            //当前股票价
            int price = prices[i];

            //临时值
            tmp = cost;

            cost = Math.min(cost, price);

            //如果发现新的最低价
            if (tmp != cost) {
                //如果已经没有购买次数了
                if (count == 0) {
                    cost = tmp;
                    break;
                } else {
                    count--;
                }
            }
            tmp = profit;
            profit = Math.max(profit, price - cost);
            if (tmp != profit) {
                if (count == 0) {
                    profit = tmp;
                    break;
                } else {
                    ++i;
                    --count;
                }
            }
        }
        return profit - (k - count) * fee;
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 每个测试用例的第1行给出村庄数目N。第一行之后的 N(N - 1) / 2 行数对应村庄间道路的成本及修建状态，每行给4个正整数，分别是两个村庄的编号（从1编号到N），此两村庄间道路的成本，以及修建状态：1表示已建，0表示未建。
     * @param N int整型 村庄数目
     * @param roads int整型二维数组 道路位置、成本、是否修建
     * @return int整型
     */

    //判断是否所有村庄齐全
    Set<Integer> nums = new HashSet();

    //每个村庄有哪些路径
    HashMap<Integer, Integer> road = new HashMap();

    //每条路径对应的最小路径
    HashMap<HashMap<Integer, Integer>, Integer> length = new HashMap();

    HashMap<String, Integer> noBuildRoad = new HashMap();
    HashMap<String, Integer> build = new HashMap();

    public int minCost (int N, int[][] roads) {

        for (int i = 0; i < roads.length; i++) {
            if (roads[i][3] == 0) {
                String str = String.valueOf(roads[i][0] + roads[i][1]);
                //如果是 不包含 / 原路径大
                if (!noBuildRoad.containsKey(str) || noBuildRoad.get(str) > roads[i][2]) {
                    noBuildRoad.put(str, roads[i][2]);
                }
                //添加进村庄
                nums.add(roads[i][0]);
                nums.add(roads[i][1]);
            } else if (roads[i][3] == 1) {
                String str = String.valueOf(roads[i][0] + roads[i][1]);
                if (!build.containsKey(str) || build.get(str) > roads[i][2]) {
                    build.put(str, roads[i][2]);
                }
            }
        }

    return 0;
    }

}
