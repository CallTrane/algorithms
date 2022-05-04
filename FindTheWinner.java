/**
 * @className: FindTheWinner
 * @description: 1823. 找出游戏的获胜者
 * @author: Carl Tong
 * @date: 2022/5/4 11:49
 */
public class FindTheWinner {
    public int findTheWinner(int n, int k) {
        // 为什么要从下标 0 开始，因为 k 是有可能满足取模后等于0，需要满足下标有对应的位置（方便操作）
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + k) % i;
        }
        // +1 的原因是跟题目编号对应
        return pos + 1;
    }
}
