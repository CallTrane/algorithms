import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @className: PushDominoes
 * @description: 838. 推多米诺
 * @author: Carl Tong
 * @date: 2022/2/21 14:20
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        // 以时间作为广度优先搜索的层次，时间快的先倒
        int[] time = new int[chars.length];
        // BFS使用队列
        Queue<Integer> queue = new ArrayDeque<>();
        // 记录初始倾倒的骨牌
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') continue;
            queue.add(i);
            time[i] = 1;
        }
        // 开始广度优先搜索
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (chars[current] == '.') continue;
            // 计算下一个要倒的骨牌是左还是右
            Integer next = current + (chars[current] == 'L' ? -1 : 1);
            if (next < 0 || next >= chars.length) continue;
            // 还没有被触碰过
            if (time[next] == 0) {
                // 记录下一个推到的骨牌
                queue.add(next);
                chars[next] = chars[current];
                time[next] = time[current] + 1;
            // 如果之前已经被碰到过，判断时间点是不是左右同时触碰的，是的话复原
            } else if (time[next] == time[current] + 1) {
                chars[next] = '.';
            }
        }
        return String.valueOf(chars);
    }
}

