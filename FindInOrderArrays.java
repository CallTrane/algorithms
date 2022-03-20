import org.junit.Test;

/**
 * 53：在排序数组中查找数字，返回该数字在数组中出现的次数
 * 思路：先通过二分查找找到该数，接着跟前一个比较（前面没有则是第一个），跟后一个比较（后面没有则是最后一个）
 *      一直二分直到找到第一个（最后一个）的索引
 */
public class FindInOrderArrays {

    public int getNumberFirst(int[] numbers, int number, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (numbers[mid] == number) {
            if ((mid > 0 && numbers[mid-1] != number) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (number > numbers[mid]) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getNumberFirst(numbers, number, start, end);
    }

    public int getNumberLast(int[] numbers, int number, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (numbers[mid] == number) {
            if ((mid > 0 && numbers[mid+1] != number) || mid == 0) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (number > numbers[mid]) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getNumberLast(numbers, number, start, end);
    }

    public int getNumberCount(int[] numbers, int number) {
        int count = 0;
        if (numbers != null || numbers.length > 0) {
            int first = getNumberFirst(numbers, number, 0, numbers.length-1);
            int last = getNumberLast(numbers, number, 0, numbers.length-1);
            //如果返回的是有效的
            if (first > -1 && last > -1) {
                count = last - first + 1;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] numbers = new int[]{1,2,2,2,2,3};
        System.out.println(getNumberCount(numbers, 1));
    }
}
