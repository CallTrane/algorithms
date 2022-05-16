package 面试;

import java.util.Arrays;

/**
 * @className: 面试.Tuhuyangche
 * @description: 途虎养车
 * @author: Carl Tong
 * @date: 2022/2/24 19:11
 */
public class Tuhuyangche {
    public long totalRun (int days) {
        int res = 0, route =  (days + 6) / 7;
        for (int i = 1; i <= route; i++) {
            int cur = 100 * i;
            int count = 6;
            res += cur; days--;
            while (count > 0 && days > 0) {
                res += (cur += 100);
                count--;
                days--;
            }
        }
        return res;
    }

    public int closestValue (int[] array, int target) {
        if (array == null || array.length <= 1) {
            return -1;
        }
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, sum = Integer.MAX_VALUE;
        while (left > 0 && array[left] >= target) {
            left--;
        }
        if (left > 0) {
            b = left; left--;
            while (left >= 0 && array[left] > target - array[b]) {
                left--;
            }
            if (left >= 0) {
                a = left;
                sum = array[a] + array[b];
            }
        }

        return a == Integer.MIN_VALUE || b == Integer.MIN_VALUE || sum > target ? -1 : sum;
    }
}
