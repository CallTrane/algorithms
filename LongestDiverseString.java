import java.util.PriorityQueue;

/**
 * @className: LongestDiverseString
 * @description: 1405. 最长快乐字符串
 * @author: Carl Tong
 * @date: 2022/2/8 18:08
 */
public class LongestDiverseString {
    public String longestDiverseString(int a, int b, int c) {
        // （字符编号, 字符剩余数量） 的二元组形式进行存储，构建以 字符剩余数量 排倒序的「大根堆」
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a != 0) maxHeap.add(new int[]{0, a});
        if (b != 0) maxHeap.add(new int[]{1, b});
        if (c != 0) maxHeap.add(new int[]{2, c});
        StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            // 贪心策略（每次尽可能地进行大数消减）可以确保能够尽可能的凑成 a = b = c
            int[] cur = maxHeap.poll();
            int length = builder.length();
            // 如果前两个已经是重复字符，则切换到下一个字符
            if (length >= 2 && (builder.charAt(length - 1) - 'a' == cur[0] && builder.charAt(length - 2) - 'a' == cur[0])) {
                // 如果已经没有下一个字符，则终止循环
                if (maxHeap.isEmpty()) break;
                int[] next = maxHeap.poll();
                builder.append((char) (next[0] + 'a'));
                // 如果添加完字符扣减数量后，当前数量还大于0，则重新加回去优先队列
                if (--next[1] > 0) maxHeap.add(next);
                maxHeap.add(cur);
            } else {
                // 否则，直接添加当前字符，扣减数量后判断
                builder.append((char) (cur[0] + 'a'));
                if (--cur[1] > 0) maxHeap.add(cur);
            }
        }
        return builder.toString();
    }
}
