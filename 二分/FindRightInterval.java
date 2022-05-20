package 二分;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: FindRightInterval
 * @description: 436. 寻找右区间
 * @author: Carl Tong
 * @date: 2022/5/21 0:24
 */
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        // 保存 {start : index} 之间的映射 （题目说start不会重复）
        Map<Integer, Integer> map = new HashMap<>(n);
        // 保存 start 数值的数组，用于遍历查找
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            map.put(start, i);
            starts[i] = start;
        }
        // 排序，用于二分查找
        Arrays.sort(starts);
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            // 如果整个数组中找不到 start >= end，直接返回
            if (end > starts[n - 1]) {
                ret[i] = -1;
                continue;
            }
            // 开始二分查找
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (starts[mid] >= end) right = mid;
                else left = mid + 1;
            }
            ret[i] = map.get(starts[left]);
        }
        return ret;
    }
}
