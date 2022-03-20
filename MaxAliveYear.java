import java.util.Arrays;

/**
 * @className: MaxAliveYear
 * @description: 面试题 16.10. 生存人数
 * @author: Carl Tong
 * @date: 2022/2/15 13:12
 */
public class MaxAliveYear {
    public int maxAliveYear(int[] birth, int[] death) {
        // 差分数组
        int[] tmp = new int[102];
        for (int i = 0; i < birth.length; i++) {
            incr(tmp, birth[i] - 1900, death[i] - 1900, 1);
        }
        int year = 0, maxAlive = Integer.MIN_VALUE;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] > maxAlive) {
                maxAlive = tmp[i];
                year = i;
            }
        }
        return year + 1900;
    }

    private void incr(int[] arr, int beginIndex, int endIndex, int val) {
        for (int i = beginIndex; i <= endIndex; i++) {
            arr[i] += val;
        }
    }
}
