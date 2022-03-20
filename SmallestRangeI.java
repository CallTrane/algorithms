import org.junit.Test;

/**
 * @className: SmallestRangeI
 * @description: 908. 最小差值 I
 * @author: carl
 * @date: 2021/8/29 16:51
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        //如果max - min <= 2K，则直接返回零
        return Math.max(0, max - min - 2*k);
    }

    @Test
    public void test() {
        int[] nums = new int[]{0,10};
        System.out.println(smallestRangeI(nums, 2));
    }
}
