/**
 * @className: MoveZeroes
 * @description: 283. 移动零
 * @author: Carl Tong
 * @date: 2022/3/17 21:24
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // 1、先把不是 0 的排序到前面
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        // 2、把后面的全部置为 0
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
}

class TestMoveZeroes {
    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}