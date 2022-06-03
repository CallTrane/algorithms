package 图;

/**
 * @className: FindCelebrity
 * @description: 277. Find the Celebrity
 * @author: Carl Tong
 * @date: 2022/6/3 17:46
 */
public class FindCelebrity {

    // 对于名人问题，显然会经常需要判断两个人之间是否认识，也就是两个节点是否相邻，所以我们可以用邻接矩阵来表示人和人之间的社交关系
    private int[][] graph;

    // 是否认识的标识符
    private final static int KNOW = 1, DONT_KNOW = -1;

    // i 是否认识 j
    private boolean knows(int i, int j) {
        return graph[i][j] == KNOW;
    }

    public int findCelebrity(int[][] graph) {
        if (graph.length == 1) return 0;
        this.graph = graph;
        // 先随便取一个作为名人, 然后继续找其他人判断
        int cand = 0;
        for (int other = 1; other < graph.length; other++) {
            /*
            对于情况一，cand 认识 other，所以 cand 肯定不是名人，排除。因为名人不可能认识别人。
            对于情况二，other 认识 cand，所以 other 肯定不是名人，排除。
            对于情况三，他俩互相认识，肯定都不是名人，可以随便排除一个。
            对于情况四，他俩互不认识，肯定都不是名人，可以随便排除一个。因为名人应该被所有其他人认识。
             */
            // cand 不可能是名人, 排除, 假设other是名人; 否则继续假设cand是名人, 什么都不用做
            if (knows(cand, other) || !knows(other, cand))
                cand = other;
        }
        for (int other = 0; other < graph.length; other++) {
            if (cand == other) continue;
            // 如果此时的"名人"认识其他人, 返回失败
            if (knows(cand, other)) return DONT_KNOW;
        }
        return cand;
    }
}
