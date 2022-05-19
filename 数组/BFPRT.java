package 数组;

import java.util.Arrays;

/**
 * @className: 数组.FindKthLargest
 * @description: 算法导论 9.3 最坏情况为线性时间的选择算法
 *               top-K 问题
 *               BFPRT
 * @author: Carl Tong
 * @date: 2022/5/19 11:14
 */
public class BFPRT {
    /**
     * 主函数入口
     *
     * @param nums The array from which select.
     * @param k    The order of the element to be selected.
     * @return The selected element.
     */
    public int topK(int[] nums, int k) {
        return bfprt(nums, 0, nums.length - 1, nums.length - k);
    }

    // bfprt里的k是从0开始的，比如说这里要求第1小，那么对应bfprt就是第0小
    public int bottomK(int[] nums, int k) {
        return bfprt(nums, 0, nums.length - 1, k - 1);
    }

    /**
     * The recursive procedure in BFPRT.
     *
     * @param arr The array from which select.
     * @param p   The start index of the sub-array from which select.
     * @param r   The end index of the sub-array from which select.
     * @param k   The k smallest
     *            <p>for example: if int[] arr = new int[]{1,2,3,4,5,6}, k ranges from 0 to 5</p>
     * @return The k smallest element
     */
    private int bfprt(int[] arr, int p, int r, int k) {
        if (p == r) return arr[p];
        int pivot = medianOfMedians(arr, p, r);
        // arr[pivotRange[0], ..., pivotRange[1]] = pivot
        int[] pivotRange = partition(arr, p, r, pivot);
        // If topK is in pivot range, then pivot is the answer
        if (p + k >= pivotRange[0] && p + k <= pivotRange[1]) return pivot; // also arr[pivotRange[0]] = pivot
        else if (p + k < pivotRange[0]) return bfprt(arr, p, pivotRange[0] - 1, k);
        else return bfprt(arr, pivotRange[1] + 1, r, k - (pivotRange[1] - p + 1));
    }

    /**
     * Compute the median of the medians of the input array.
     *
     * @param arr The array to be computed.
     * @param p   The start index of the sub-array.
     * @param r   The end index of the sub-array.
     * @return The median of the medians of the sub-array.
     */
    private int medianOfMedians(int[] arr, int p, int r) {
        // number of groups (groups of five elements)
        int num = (r - p + 1 + 4) / 5;
        int[] medians = new int[num];
        for (int i = 0; i < medians.length; i++) {
            int start = p + i * 5, end = Math.min(start + 4, r);
            medians[i] = computeMedian(arr, start, end);
        }
        // Recursive call select(bfprt), return the median of the medians.
        return bfprt(medians, 0, medians.length - 1, medians.length / 2);
    }

    /**
     * Compute the median of the given array.
     *
     * @param arr   Array to be computed.
     * @param start The beginning index of the range to be computed.
     * @param end   The end index of the range to be computed.
     * @return The median of the array in the specified range.
     */
    private int computeMedian(int[] arr, int start, int end) {
        Arrays.sort(arr, start, end + 1);
        return arr[start + ((end - start) >> 1)];
    }

    /**
     * Partition the array into two parts.
     * <p>
     * After this method, elements less than pivot are put left, pivots are put middle, others are put right.
     *
     * @param arr   The array to be sorted.
     * @param p     The start index of the sub-array to be sorted.
     * @param r     The end index of the sub-array to be sorted.
     * @param pivot The value of an element in an array
     * @return An array of two elements about the pivot index range.
     * The first element indicates the index of the first pivot, the second element indicates the index of the last pivot.
     */
    private int[] partition(int[] arr, int p, int r, int pivot) {
        // arr[small + 1, ..., small + equal] = pivot
        int small = p - 1, equal = 0;
        for (int i = p; i <= r; i++) {
            if (arr[i] < pivot) {
                small++;
                // If the element value of pivot was found before, arr[small] is pivot now, so move it to the middle
                if (equal > 0) swap(arr, small, small + equal);
                swap(arr, small, i);
            } else if (arr[i] == pivot) {
                equal++;
                // arr[i] = pivot, move it to the middle
                swap(arr, small + equal, i);
            }
        }
        return new int[]{small + 1, small + equal};
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
