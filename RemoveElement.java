/**
 * @className: RemoveElement
 * @description: 27. 移除元素
 * @author: Carl Tong
 * @date: 2022/3/17 18:13
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == val) continue;
            nums[slow] = nums[fast];
            slow++;
        }
        return slow;
    }
}

class TRE {
    public static void main(String[] args) {
        new RemoveElement().removeElement(new int[]{3,2,2,3}, 3);
    }
}
