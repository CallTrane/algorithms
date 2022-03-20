/**
 * @className: FindNthDigit
 * @description: 剑指 Offer 44. 数字序列中某一位的数字
 * @author: carl
 * @date: 2021/9/9 12:58
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count =  9 * digit * start;
        }
        //得出是哪个数字
        long num = start + (n - 1) / digit;
        //将数字num转换为字符串
        String str = Long.toString(num);
        //确定是字符串哪一位
        return str.charAt( (n-1) % digit) - '0';
    }
}
