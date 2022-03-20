/**
 * @className: FindKthLargest
 * @description: 215. 数组中的第K个最大元素 || 剑指 Offer II 076. 数组中的第 k 大的数字
 * @author: carl
 * @date: 2021/9/12 17:27
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
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
    }
}
