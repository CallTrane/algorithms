package 字符串;

/**
 * @className: IsAlienSorted
 * @description: 953. 验证外星语词典
 * @author: Carl Tong
 * @date: 2022/5/17 13:27
 */
public class IsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alphabetOrder = new int[26];
        // 下标 0 ~ 25 对应字母，索引值对应位置
        for (int i = 0; i < order.length(); i++) alphabetOrder[order.charAt(i) - 'a'] = i;
        // 每次比对两个字符串
        for (int i = 1; i < words.length; i++) {
            if (!check(words[i - 1], words[i], alphabetOrder)) return false;
        }
        return true;
    }

    // 检查是否有序
    private boolean check(String prev, String next, int[] alphabetOrder) {
        int i = 0, n = prev.length(), j = 0, m = next.length();
        while (i < n && j < m) {
            int c1 = prev.charAt(i) - 'a', c2 = next.charAt(j) - 'a';
            if (c1 != c2) return alphabetOrder[c1] < alphabetOrder[c2];
            i++; j++;
        }
        // 判断是不是前一个先结束
        if (i == n) return true;
        return false;
    }
}
