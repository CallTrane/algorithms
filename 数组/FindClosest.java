package 数组;

/**
 * @className: FindClosest
 * @description: 面试题 17.11. 单词距离
 * @author: Carl Tong
 * @date: 2022/5/27 10:49
 */
public class FindClosest {
    public int findClosest(String[] words, String word1, String word2) {
        // 用双指针遍历
        int p = -1, q = -1, ret = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            if (word1.equals(cur)) p = i;
            else if (word2.equals(cur)) q = i;
            if (p != -1 && q != -1) ret = Math.min(ret, Math.abs(p - q));
        }
        return ret;
    }
}
