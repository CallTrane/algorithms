/**
 * @className: StringToInt
 * @description: 剑指 Offer 67. 把字符串转换成整数
 * @author: carl
 * @date: 2021/8/24 15:09
 */
public class StringToInt {
    public int strToInt(String str) {
        int result = 0, boundry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if (length == 0) {
            return 0;
        }
        while (str.charAt(i) == ' ') {
            ++i;
            if (i == length) {
                return 0;
            }
        }
        if (str.charAt(i) == '-') {
            sign = -1;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            ++i;
        }
        for (int j = i; j < length; j++) {
            //如果发现有不是数字的，直接跳出循环
            if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }
            //如果越界
            if (result > boundry || (result == boundry && str.charAt(j) > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(j) - '0');
        }
        return sign * result;
    }
}
