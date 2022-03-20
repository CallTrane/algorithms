import java.util.*;
import java.util.stream.Collectors;

/**
 * @className: OpenLock
 * @description: 752. 打开转盘锁
 * @author: Carl Tong
 * @date: 2022/3/14 15:37
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> deads = Arrays.stream(deadends).collect(Collectors.toSet());
        Set<String> visited = new HashSet<>();
        if (!deads.contains("0000")) queue.offer("0000");
        int res = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String cur = queue.poll();
                if (target.equals(cur)) return res;
                // 对每个位置尝试反转
                for (int j = 0; j < cur.length(); j++) {
                    String up = up(cur, j), down = down(cur, j);
                    if (!(deads.contains(up) || visited.contains(up))) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    if (!(deads.contains(down) || visited.contains(down))) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            res++;
        }
        // 如果穷举完都没找到目标密码，那就是找不到了
        return -1;
    }

    private String up(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '9') chars[index] = '0';
        else chars[index] += 1;
        return String.valueOf(chars);
    }

    private String down(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '0') chars[index] = '9';
        else chars[index] -= 1;
        return String.valueOf(chars);
    }
}

class YTuida {
    public static void main(String[] args) {
        System.out.println(new OpenLock().openLock(new String[]{"0000"}, "8888"));
    }
}
