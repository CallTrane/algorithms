package 数组;

import java.util.Arrays;

/**
 * @className: FindKthLargest
 * @description: 215. 数组中的第K个最大元素
 *               剑指 Offer II 076. 数组中的第 k 大的数字
 * @author: carl
 * @date: 2021/9/12 17:27
 */
public class FindKthLargest {

    // bfprt解法
    public int findKthLargest(int[] nums, int k) {
        return bfprt(nums, 0, nums.length - 1, nums.length - k);
    }

    private int bfprt(int[] arr, int p, int r, int k) {
        if (p == r) return arr[p];
        // mutual recursion
        int pivot = medianOfMedians(arr, p, r);
        int[] pivotRange = partition(arr, p, r, pivot);
        if (p + k >= pivotRange[0] && p + k <= pivotRange[1]) return pivot;
        else if (p + k < pivotRange[0]) return bfprt(arr, p, pivotRange[0] - 1, k);
        else return bfprt(arr, pivotRange[1] + 1, r, k - (pivotRange[1] - p + 1));
    }

    private int medianOfMedians(int[] arr, int p, int r) {
        int size = (r - p + 1 + 4) / 5;
        int[] medians = new int[size];
        for (int i = 0; i < size; i++) {
            int start = p + i * 5, end = Math.min(start + 4, r);
            medians[0] = getMedian(arr, start, end);
        }
        // mutual recursion
        return bfprt(arr, 0, medians.length - 1, medians.length / 2);
    }

    private int getMedian(int[] arr, int p, int r) {
        Arrays.sort(arr, p, r + 1);
        return arr[p + ((r - p) >> 1)];
    }

    private int[] partition(int[] arr, int p, int r, int pivot) {
        int small = p - 1, equal = 0;
        for (int i = p; i <= r; i++) {
            if (arr[i] < pivot) {
                small++;
                // before swap, arr[small] = pivot, arr[small + equal] > pivot
                if (equal > 0) swap(arr, small, small + equal);
                swap(arr, i, small);
            } else if (arr[i] == pivot) {
                equal++;
                swap(arr, i, small + equal);
            }
        }
        return new int[]{small + 1, small + equal};
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    // 堆排序解法
    /*public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int heapSize = nums.length;
        buildHeapify(nums, heapSize);
        for (int i = 1; i < k; i++) {
            swap(nums, 0, heapSize-1);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildHeapify(int[] nums, int heapSize) {
        for (int i = heapSize/2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public void maxHeapify(int[] nums, int i, int heapSize) {
        int largest = i, left = 2*i + 1, right = 2*i + 2;
        if (left < heapSize && nums[largest] < nums[left]) {
            largest = left;
        }
        if (right < heapSize && nums[largest] < nums[right]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            //交换之后，要继续对交换后的节点进行堆排序（防止破坏）
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }*/
}
