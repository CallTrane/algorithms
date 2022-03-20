import org.junit.Test;

/**
 * 03题目：在一个长度为n的数组，所有数组都在0~n-1的范围内，找出任意一个重复的数字
 * 思路：（空间复杂度O(1)，时间复杂度O(n)）当数组排序之后，数字i将出现在下标为i的位置
 *      返回-1代表参数有误，返回数组长度代表数组没有重复值
 */
public class ArraysRepeat1 {

    public int duplicate(int numbers[]) {
        //判断数组是否为空
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }
        int length = numbers.length;
        //判断值是否越界
        for (int i : numbers) {
            if (i < 0 || i > length - 1) {
                return -1;
            }
        }

        for (int i = 0; i < length; i++) {
            //如果下标不对应的话，需要一直循环交换值
            while (i != numbers[i]) {
                //判断坐标上的值是否已经对齐，如果已经对齐了说明已经重复
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                //交换值
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return length;
    }

    @Test
    public void test1() {
        int[] numbers1 = new int[]{1,2,3,0};
        int[] numbers2 = new int[0];
        int[] numbers3 = new int[]{1,2,3,4};
        System.out.println(duplicate(numbers1));
    }


}


