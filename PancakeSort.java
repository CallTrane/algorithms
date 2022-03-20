import java.util.ArrayList;
import java.util.List;

/**
 * @className: PancakeSort
 * @description: 969. 煎饼排序
 * @author: Carl Tong
 * @date: 2022/2/19 15:21
 */
public class PancakeSort {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        // 类冒泡排序，每次将最大的反转两次放在后面
        for (int i = arr.length; i > 0; i--) {
            // 记录当前子区间最大的元素下标
            int index = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[index]) index = j;
            }
            // 如果最大的已经在子区间末尾，则继续下一轮
            if (index == i - 1) continue;
            // 否则，则将当前元素反转到最前面，再反转到子区间末尾
            reverse(arr, index);
            reverse(arr, i - 1);
            res.add(index + 1);
            res.add(i);
        }
        return res;
    }

    private void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
