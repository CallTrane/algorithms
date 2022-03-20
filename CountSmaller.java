import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: CountSmaller
 * @description: 315. 计算右侧小于当前元素的个数
 * @author: Carl Tong
 * @date: 2022/3/18 1:58
 */
public class CountSmaller {

    private class Pair {
        // 记录数组索引
        int index;
        // 记录对应值
        int val;
        public Pair (int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    // 归并排序辅助数组
    private Pair[] tmp;
    // 要求返回的答案
    private int[] counts;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        tmp = new Pair[n];
        counts = new int[n];
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++)
            arr[i] = new Pair(i, nums[i]);
        sort(arr, 0, n - 1);
        List<Integer> res = new ArrayList<>();
        Arrays.stream(counts).forEach(i -> res.add(i));
        return res;
    }

    private void sort(Pair[] arr, int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        sort(arr, left ,mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(Pair[] arr, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tmp[i] = arr[i];
        }
        int leftIndex = left, rightIndex = mid + 1;
        // rightIndex - mid + 1 就是右侧比他小的元素，只有左半部分且tmp[leftIndex].val <　tmp[rightIndex++].val 能计算
        for (int i = left; i <= right; i++) {
            if (leftIndex == mid + 1) arr[i] = tmp[rightIndex++];
            else if (rightIndex == right + 1) {
                arr[i] = tmp[leftIndex++];
                // 因为是分成多个部分去计算的，所以是要+=
                counts[arr[i].index] += rightIndex - mid - 1;
            }
            else if (tmp[leftIndex].val > tmp[rightIndex].val) arr[i] = tmp[rightIndex++];
            else {
                arr[i] = tmp[leftIndex++];
                // 因为是分成多个部分去计算的，所以是要+=
                counts[arr[i].index] += rightIndex - mid - 1;
            }
        }
    }
}
