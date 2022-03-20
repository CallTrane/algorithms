/**
 * @className: ConvertToBase7
 * @description: 504. 七进制数
 * @author: Carl Tong
 * @date: 2022/3/7 13:24
 */
public class ConvertToBase7 {
    public String convertToBase7(int num) {
        if (num > -7 && num < 7) return String.valueOf(num);
        StringBuilder builder = new StringBuilder();
        int value = Math.abs(num);
        while (value != 0) {
            builder.append(value % 7);
            value /= 7;
        }
        if (num < 0) builder.append("-");
        return builder.reverse().toString();
    }
}
