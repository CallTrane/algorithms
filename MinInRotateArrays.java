import org.junit.Test;

/**
 * 11：旋转数组中的最小数字
 */
public class MinInRotateArrays {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[right] > numbers[mid]) {
                right = mid;
            } else {
                int result = left;
                for (int j = left+1; j < right; j++) {
                    if (numbers[left] > numbers[j]) {
                        result = j;
                        break;
                    }
                }
                return numbers[result];
            }
        }
        return numbers[left];
    }

    @Test
    public void test() throws Exception {
        int[] numbers = new int[]{1,3,5};
        System.out.println(minArray(numbers));
    }
}
