/**
 * @className: CountRangeSum
 * @description: 327. 区间和的个数
 * @author: Carl Tong
 * @date: 2022/3/19 16:02
 */
public class CountRangeSum {

    private long[] tmp;

    private int lower, upper;
    private int count = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        // 前缀和数组，int 可能溢出，用 long 存储
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        this.lower = lower;
        this.upper = upper;
        sort(preSum);
        return count;
    }

    private void sort(long[] preSum) {
        tmp = new long[preSum.length];
        sort(preSum, 0, preSum.length - 1);
    }

    private void sort(long[] preSum, int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        sort(preSum, left, mid);
        sort(preSum, mid + 1, right);
        merge(preSum, left, mid, right);
    }

    private void merge(long[] preSum, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tmp[i] = preSum[i];
        }
        // 1、先计算 lo <= i <= mid，我们在找到的符合条件的 mid+1 <= j <= hi，必然也符合
        int start = mid + 1, end = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (start <= right && preSum[start] - preSum[i] < lower) start++;
            // 这里要让 end 右移一个单位，不然重合无法计算
            while (end <= right && preSum[end] - preSum[i] <= upper) end++;
            // (end - 1) - start + 1
            count += end - start;
        }
        // 2、再排序
        int leftIndex = left, rightIndex = mid + 1;
        for (int i = left; i <= right; i++) {
            if (leftIndex == mid + 1) preSum[i] = tmp[rightIndex++];
            else if (rightIndex == right + 1) preSum[i] = tmp[leftIndex++];
            else if (tmp[leftIndex] > tmp[rightIndex]) preSum[i] = tmp[rightIndex++];
            else preSum[i] = tmp[leftIndex++];
        }
    }
}
