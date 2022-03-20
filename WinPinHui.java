import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @className: WinPinHui
 * @description: TODO
 * @author: carl
 * @date: 2021/9/15 14:39
 */
public class WinPinHui {

    /**
     * SELECT DISTINCT `sku_name`,`category`, num
     * FROM `sku_info`,`sales`,
     * (
     *     SELECT sku_no, SUM(`qty`) num
     *     FROM `sales`
     *     WHERE order_date > '2021-08-25 21:42:38'
     *     GROUP BY sku_no
     * ) AS n
     * WHERE `sku_info`.`sku_no`=`sales`.`sku_no` AND n.sku_no=`sales`.`sku_no`
     * ORDER BY num DESC;
     */

    public int maxProfit (int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price-min);
        }
        return profit;
    }

    public int maxSum (String[] words) {
        int result = 0;
        if (words.length <= 1) {
            return result;
        }
        for (int i = 0; i < words.length - 1; i++) {
            char[] pre = words[i].toCharArray();
            int tmp = 0;
            for (int j = i+1; j < words.length; j++) {
                char[] cur = words[j].toCharArray();
                tmp = hasCommonChar(pre, cur) + hasCommonChar(cur, pre);
                result = Math.max(result, tmp);
            }
        }
        return result;
    }

    public int hasCommonChar(char[] pre, char[] cur) {
        Set<Character> set = new HashSet();
        int temp = 0;
        for (int i = 0; i < pre.length; i++) {
            if (set.contains(pre[i])) {
                continue;
            } else {
                set.add(pre[i]);
            }
            int current = 0;
            while (current < cur.length) {
                if (pre[i] == cur[current]) {
                    break;
                }
                current++;
            }
            if (current == cur.length) {
                temp++;
            }
        }
        return temp;
    }
}
