import org.junit.Test;

/**
 * 题目：长度为n+1的数组里所有数字都在1~n的范围内，找出任意一个重复数字，但不能修改输入的数组
 * 思路：（空间复杂度O(1)，时间复杂度O(nlogn)）二分法，将1~n的数字分成1~m和m+1~n，如果1~m的数字个数超过m，说明这个区间有重复数字；否则亦此
 *      如果反复划分，直到找到任意一个重复数字
 *      （空间复杂度O(n)，时间复杂度O(n)）借助一个辅助空间，把需要被复制的数字，复制到数组即可
 *
 */

public class ArraysRepeat2 {

    @Test
    public void test() {
        int[] numbers = new int[]{2,3,5,4,3,2,6,7};
        System.out.println(duplicate(numbers));
    }

    public int countRange(int[] numbers, int start, int end) {
        if (numbers == null || numbers.length <= 0) {
            return 0;
        }
        int count = 0;
        //只要数字是在范围内的，count就+1
        for (int i : numbers) {
            if (i >= start && i <= end) {
                ++count;
            }
        }
        return count;
    }

    public int duplicate(int numbers[]) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }
        int start = 1;
        int end = numbers.length - 1;
        while (end >= start) {
            //分为两部分
            int middle = start + ((end - start) >> 1);
            //计算区间内数字出现的次数
            int count = countRange(numbers, start ,middle);
            //当区间唯一时，就是该重复值
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            //如果左区间总数大于范围总数，说明重复数字是在左区间
            if (count > (middle - start +1)) {
                //则将结束标志替换为左区间
                end = middle;
            } else {
                //否则，则是将开始标志替换右区间
                start = middle;
            }
        }
        return -1;
    }


}
