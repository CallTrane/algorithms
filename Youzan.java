/**
 * @className: Youzan
 * @description: TODO
 * @author: carl
 * @date: 2021/9/11 14:41
 */
public class Youzan {

    public boolean method1 (int num) {
        if (num < 0) {
            return false;
        }
        //1234321
        int reserve = 0;
        int temp = num;
        while (temp != 0) {
            reserve = reserve * 10 + temp % 10;
            temp /= 10;
        }
        return reserve == num;
    }

    public int numDecodings (String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        /**
         * i = (i-1)
         * i = (i-1) + (i-2)
         */

        char[] nums = s.toCharArray();

        int result = 1, resultTmp = 1;
        int left, right = Integer.valueOf(nums[nums.length-1] - '0');
        for (int i = nums.length-2; i >= 0; i--) {
            left = Integer.valueOf(nums[i] - '0');
            int temp = (left * 10 + right);
            int ans = (10 <= temp && temp <= 26) ? ans = result + resultTmp : result;
            resultTmp = result;
            result = ans;
            right = left;
        }

        /*while (num != 0) {
            num /= 10;
            left = num % 10;
            long temp = 10 * left + right;
            int ans = 0;
            if (10 <= temp && temp <= 26) {
                ans = result + resultTmp;
            } else {
                ans = result;
            }
            resultTmp = result;
            result = ans;
            right = left;
        }*/
        return result;
    }
}
