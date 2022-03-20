import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @className: StockPrice
 * @description: 2034. 股票价格波动
 * @author: Carl Tong
 * @date: 2022/1/23 15:04
 */
public class StockPrice {

    /**
     * 用于保存当前的时间
     */
    int currentTime;

    /**
     * 用哈希表来维护 {时间:价格} 的映射关系
     */
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 用红黑树来维护 {价格:出现过该价格的时间戳次数} 价格排序
     */
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public void update(int timestamp, int price) {
        // 更新最新时间
        currentTime = Math.max(currentTime, timestamp);
        // 判断之前是否已经有存在过该时间戳，如果有的话需要更正
        if (map.containsKey(timestamp)) {
            // 获取到之前的价格
            int oldPrice = map.get(timestamp);
            // 判断红黑树出现过该价格的次数，如果只有1次就直接移除该key（表示出现过该价格的时间戳已被移除），大于1次就减少1
            int count = treeMap.get(oldPrice);
            if (count == 1) {
                treeMap.remove(oldPrice);
            } else {
                treeMap.put(oldPrice, count - 1);
            }
        }
        // 更新价格
        map.put(timestamp, price);
        treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return map.get(currentTime);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }
}
