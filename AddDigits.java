/**
 * @className: AddDigits
 * @description: 258. 各位相加
 * @author: Carl Tong
 * @date: 2022/3/3 13:54
 */
public class AddDigits {
    public int addDigits(int num) {
        while (num > 9) {
            int cur = num % 10, next = num / 10, sum = 0;
            while (true) {
                sum += cur;
                num = sum;
                if (next == 0) break;
                cur = next % 10;
                next = next / 10;
            }
        }
        return num;
    }
}

class TAddDigits {
    public static void main(String[] args) {
        new AddDigits().addDigits(38);
    }
}
