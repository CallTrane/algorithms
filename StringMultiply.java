/**
 * @className: StringMultiply
 * @description: 43. 字符串相乘
 * @author: Carl Tong
 * @date: 2022/2/10 22:30
 */
public class StringMultiply {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int res[] = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + n1 * n2;
                res[i + j + 1] = sum % 10;
                // 这是数组，可以存储两位数的，最后会推给res[0]解决（因为只是两个数相乘）
                res[i + j] += sum / 10;
            }
        }
        String result = "";
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[0] == 0) continue;
            result += res[i];
        }
        return result;
    }
}
