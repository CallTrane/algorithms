import java.util.*;

/**
 * @className: WatchedVideosByFriends
 * @description: 1311. 获取你好友已观看的视频
 * @author: Carl Tong
 * @date: 2022/2/23 17:50
 */
public class WatchedVideosByFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        // 用于记录是否为重复好友
        Set<Integer> set = new HashSet<>();
        queue.offer(id); set.add(id);
        while (!queue.isEmpty() && level > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer curId = queue.poll();
                for (int subId : friends[curId]) {
                    if (!set.contains(subId)) {
                        queue.offer(subId);
                        set.add(subId);
                    }
                }
            }
            level--;
        }
        TreeMap<String, Integer> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            List<String> strings = watchedVideos.get(queue.poll());
            for (String s : strings) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        List<String> res = new ArrayList<>(map.keySet());
        res.sort((a, b) -> {
            if (map.get(a).equals(map.get(b))) return a.compareTo(b);
            return map.get(a) - map.get(b);
        });
        return res;
    }
}
