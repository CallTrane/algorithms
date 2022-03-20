import org.junit.Test;

/**
 * @className: MinNumber
 * @description: 剑指 Offer 45. 把数组排成最小的数
 * @author: carl
 * @date: 2021/8/24 18:52
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length-1);
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder.append(s);
        }
        return builder.toString();
    }

    private void quickSort(String[] strs, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = getIndex(strs, start, end);
        quickSort(strs, start, index-1);
        quickSort(strs, index+1, end);
    }

    private int getIndex(String[] strs, int left, int right) {
        int low = left;
        String tmp = null;
        while (left < right) {
            while (left < right && (strs[right]+strs[low]).compareTo((strs[low]+strs[right])) >= 0) {
                right--;
            }
            while (left < right && (strs[left]+strs[low]).compareTo((strs[low]+strs[left])) <= 0) {
                left++;
            }
            tmp = strs[left];
            strs[left] = strs[right];
            strs[right] = tmp;
        }
        strs[left] = strs[low];
        strs[low] = tmp;
        return left;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(minNumber(nums));
    }
}
