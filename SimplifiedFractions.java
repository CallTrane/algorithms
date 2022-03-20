import java.util.ArrayList;
import java.util.List;

/**
 * @className: SimplifiedFractions
 * @description: 1447. 最简分数
 * @author: Carl Tong
 * @date: 2022/2/10 13:33
 */
public class SimplifiedFractions {

    /**
     * 欧几里得算法求最大公约数
     *
     * @param a 除数
     * @param b 被除数
     * @return
     */
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 如果最大公约数为1，说明已经最简分数
                if (gcd(j, i) == 1) ans.add(j + "/" + i);
            }
        }
        return ans;
    }
}
