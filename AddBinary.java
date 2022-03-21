/**
 * @className: AddBinary
 * @description: 剑指 Offer II 002. 二进制加法
 * @author: Carl Tong
 * @date: 2022/3/21 1:31
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        int n = Math.max(n1, n2), sum = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 从后往前算
            sum += i >= n1 ? 0 : a.charAt(n1 - 1 - i) - '0';
            sum += i >= n2 ? 0 : b.charAt(n2 - 1 - i) - '0';
            builder.append(sum % 2);
            sum /= 2;
        }
        if (sum > 0) builder.append(1);
        return builder.reverse().toString();
    }
}
