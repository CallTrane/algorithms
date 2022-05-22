package 动态规划.博弈问题;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: CanIWin
 * @description: 464. 我能赢吗
 * @author: Carl Tong
 * @date: 2022/5/22 17:50
 */
public class CanIWin {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            // 如果最大的数字比期望总数大，则先手稳赢
            if (maxChoosableInteger >= desiredTotal) return true;
            // 如果所有数字总和比期望总数小，则先手稳输
            if ((maxChoosableInteger + 1) / 2 * maxChoosableInteger < desiredTotal) return false;
            Map<Integer, Boolean> memo = new HashMap();
            return dfs(memo, 0, maxChoosableInteger, 0, desiredTotal);
        }

        public boolean dfs(Map<Integer, Boolean> memo, int useNumbers, int maxChoosableInteger, int curTotal, int desiredTotal) {
            if (!memo.containsKey(useNumbers)) {
                boolean ans = false;
                for (int i = 0; i < maxChoosableInteger; i++) {
                    // 如果该数字已经被选过了
                    if (((useNumbers >> i) & 1) == 1) continue;
                    // 先手取 i 看能不能赢
                    if (curTotal + i + 1 >= desiredTotal) {
                        ans = true;
                        break;
                    }
                    // 如果不行，轮到对方取数字，如果对方不能赢那我也赢
                    if (!dfs(memo, useNumbers | (1 << i), maxChoosableInteger, curTotal + i + 1, desiredTotal)) {
                        ans = true;
                        break;
                    }
                }
                // 都不行，那我输了
                memo.put(useNumbers, ans);
            }
            return memo.get(useNumbers);
        }
}
