import java.util.HashMap;

/**
 * @className: LemonadeChange
 * @description: 860. 柠檬水找零
 * @author: Carl Tong
 * @date: 2022/2/28 17:27
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) return false;
        HashMap<Integer, Integer> map = new HashMap(2);
        for (int bill : bills) {
            if (bill == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
                continue;
            }
            if (bill == 10) {
                if (map.get(5) < 1) {
                    return false;
                } else {
                    map.put(5, map.getOrDefault(5, 0) - 1);
                    map.put(10, map.getOrDefault(10, 0) + 1);
                    continue;
                }
            }
            // 如果为20，则优先把10元的先花了（贪心）
            if (bill == 20) {
                // 10 + 5
                Integer tenCount = map.get(10), fiveCount = map.get(5);
                if ((tenCount != null && tenCount > 0) && fiveCount > 0) {
                    map.put(5, fiveCount - 1);
                    map.put(10, tenCount - 1);
                    continue;
                // 5 + 5 + 5
                } else if (map.get(5) > 2) {
                    map.put(5, fiveCount - 3);
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}

class T3 {
    public static void main(String[] args) {
        new LemonadeChange().lemonadeChange(new int[]{5,5,5,10,20});
    }
}