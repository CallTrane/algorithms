/**
 * @className: Shopee
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/7 19:21
 */
public class Shopee {
    public long GetSubArrayMaxProduct(long[] nums) {
        long maximum = nums[0], minimum = nums[0], res = 0;
        for (int i = 1; i < nums.length; i++) {
            long curMax = maximum, curMin = minimum;
            maximum = Math.max(curMax * nums[i], Math.max(nums[i], curMin * nums[i]));
            minimum = Math.min(curMin * nums[i], Math.min(nums[i], curMax * nums[i]));
            res = Math.max(maximum, res);
        }
        return res;
    }


    public long GetMinCalculateCount(long sourceX, long sourceY, long targetX, long targetY) {
        return recur(0, sourceX, sourceY, targetX, targetY);
    }

    public int recur(int count, long sourceX, long sourceY, long targetX, long targetY) {
        if (sourceX == targetX && sourceY == targetY) return count;
        if (sourceX >= targetX || sourceY >= targetY) return -1;
        int a = recur(count + 1, sourceX + 1, sourceY + 1, targetX, targetY);
        int b = recur(count + 1, sourceX * 2, sourceY * 2, targetX, targetY);
        // a > 0 b > 0 b = -1 a = -1
        return (a == -1 && b == -1) ? -1 : (a > 0 && b > 0) ? Math.min(a, b) : Math.max(a, b);
    }

    /**
     * 'N': 没有逾期，正常  'Y'：有逾期
     *
     * @param dpdInfo
     * @return
     */
    public int calDPDScore(String dpdInfo) {
        if (dpdInfo == null || dpdInfo.length() <= 0) return 0;
        int index = 0, maximum = 0;
        while (index < dpdInfo.length()) {
            // 先找到首个逾期
            while (index < dpdInfo.length() && dpdInfo.charAt(index) != 'Y') index++;
            // 判断连续多少个
            int count = 0;
            while (index < dpdInfo.length() && dpdInfo.charAt(index) == 'Y') {
                count++;
                index++;
            }
            maximum = Math.max(maximum, count);
        }
        return calculate(maximum);
    }

    private int calculate(int count) {
        if (count == 0) {
            return 0;
        } else if (count < 3) {
            return -10;
        } else if (count <= 7) {
            return -15;
        } else {
            return -25;
        }
    }
}

class TestShopee {
    public static void main(String[] args) {
        Shopee shopee = new Shopee();
        //shopee.GetSubArrayMaxProduct(new long[]{2,3,-2,-4,1});
        System.out.println(shopee.GetMinCalculateCount(1, 2, 4, 6));
    }
}
