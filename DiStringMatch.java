/**
 * @className: DiStringMatch
 * @description: 942. 增减字符串匹配
 * @author: Carl Tong
 * @date: 2022/5/9 1:07
 */
public class DiStringMatch {
    public int[] diStringMatch(String s) {
        // 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
        // 贪心 + 双指针 : 只要遇到 I 就选择剩余最小的数字；只要遇到 D 就选择剩余最大的数字
        int n = s.length(), low = 0, high = n;
        int[] perm = new int[n + 1];
        for (int i = 0; i < n; i++) {
            perm[i] = s.charAt(i) == 'I' ? low++ : high--;
        }
        // 最后剩下一个数，此时 low == high
        perm[n] = high;
        return perm;
    }
}
