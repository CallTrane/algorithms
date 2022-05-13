/**
 * @className: OneEditAway
 * @description: 面试题 01.05. 一次编辑
 * @author: Carl Tong
 * @date: 2022/5/13 20:23
 */
public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        int n = first.length(), m = second.length();
        if (Math.abs(n - m) > 1) return false;
        // 让 n <= m
        if (n > m) return oneEditAway(second, first);
        int i = 0, j = 0;
        boolean canEdit = true;
        while (i < n && j < m) {
            if (first.charAt(i) == second.charAt(j)) {
                i++; j++;
            } else {
                if (!canEdit) return false;
                // 如果长度相同做修改，同时移动，否则短的不用移动
                if (n == m) i++;
                j++; canEdit = false;
            }
        }
        return true;
    }
}
