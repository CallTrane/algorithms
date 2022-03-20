/**
 * @className: PrintNumbers
 * @description: 剑指 Offer 17. 打印从1到最大的n位数
 * @author: carl
 * @date: 2021/9/11 20:32
 */
public class PrintNumbers {

    int[] result;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int nineCount = 0, start, n, index = 0;

    public int[] printNumbers(int n) {
        this.n = n;
        start = n - 1;
        result = new int[(int)Math.pow(10, n)-1];
        num = new char[n];
        dfs(0);
        return result;
    }

    public void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) {
                result[index++]  = Integer.valueOf(s);
            }
            if (n - start == nineCount) {
                start--;
            }
            return;
        }
        for (char c : loop) {
            if (c == '9') {
                nineCount++;
            }
            num[x] = c;
            dfs(x+1);
        }
        nineCount--;
    }
}
