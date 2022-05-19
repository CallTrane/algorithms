package 数组;

import java.util.Arrays;

/**
 * @className: MinMoves2
 * @description: 462. 最少移动次数使数组元素相等 II
 * @author: Carl Tong
 * @date: 2022/5/19 11:01
 */
public class MinMoves2 {

    public int minMoves2(int[] nums) {
        // target 必须是不断选择数组（及子数组）最大值、最小值之间的数字，最终就是「中位数」
        int target = BFPRT.bfprt(nums, 0, nums.length - 1, nums.length / 2);
        return Arrays.stream(nums).reduce(0, (a, b) -> a + Math.abs(b - target));
    }

    static class BFPRT {
        // 找出这组数组中，第k小的元素（注意：这里的k索引是从0开始）
        public static int bfprt(int[] arr, int p, int r, int k) {
            if (p == r) return arr[p];
            // 将数组划分为 n/5 组，找出每组中位数后，继续找这些中位数的中位数作为划分的主元（注意：bfprt是mutual recursion，即相互递归）
            int pivot = medianOfMedians(arr, p, r);
            int[] pivotRange = partition(arr, p, r, pivot);
            if (p + k >= pivotRange[0] && p + k <= pivotRange[1]) return pivot;
            else if (p + k < pivotRange[0]) return bfprt(arr, p, pivotRange[0] - 1, k);
            else return bfprt(arr, pivotRange[1] + 1, r, k - (pivotRange[1] - p + 1));
        }

        // 获取中位数的中位数
        private static int medianOfMedians(int[] arr, int p, int r) {
            // 中位数数组大小
            int size = (r - p + 1 + 4) / 5;
            int[] medians = new int[size];
            for (int i = 0; i < size; i++) {
                int start = p + i * 5, end = Math.min(start + 4, r);
                medians[i] = getMedian(arr, p, r);
            }
            // 通过相互递归调用，找到这组中位数的中位数（注意：bfprt是mutual recursion，即相互递归）
            return bfprt(medians, 0, medians.length - 1, medians.length / 2);
        }

        // 对数组进行排序，并返回其中位数
        private static int getMedian(int[] arr, int start, int end) {
            Arrays.sort(arr, start, end + 1);
            return arr[start + ((end - start) >> 1)];
        }

        // 通过主元划分，把等于主元的放在中间，小于的放在左边，其余的放在右边
        private static int[] partition(int[] arr, int p, int r, int pivot) {
            int small = p - 1, equal = 0;
            for (int i = p; i <= r; i++) {
                if (arr[i] < pivot) {
                    small++;
                    if (equal > 0) swap(arr, small, small + equal);
                    swap(arr, small, i);
                } else if (arr[i] == pivot) {
                    equal++;
                    swap(arr, small + equal, i);
                }
            }
            return new int[]{small + 1, small + equal};
        }

        private static void swap(int[] arr, int a, int b) {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }
    }
}
