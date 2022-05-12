/**
 * @className: MinDeletionSize
 * @description: 944. 删列造序
 * @author: Carl Tong
 * @date: 2022/5/12 17:37
 */
public class MinDeletionSize {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length(), res = 0;
        for (int i = 0; i < m; i++) {
            char pre = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                char c = strs[j].charAt(i);
                if (pre > c) {
                    res++;
                    break;
                }
                pre = c;
            }
        }
        return res;
    }

}

class TestMinDeletionSize {
    public static void main(String[] args) {
        new MinDeletionSize().minDeletionSize(new String[]{"cba", "daf", "ghi"});
    }
}
