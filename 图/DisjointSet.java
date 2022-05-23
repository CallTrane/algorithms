package 图;

/**
 * @className: DisjointSet
 * @description: 不相交集合（并查集）
 * @author: Carl Tong
 * @date: 2022/3/6 19:08
 */
public class DisjointSet {
    // 结点信息，node[i]的值表示第 i 个结点的的根结点（集合元素代表）
    int[] nodes;
    int[] depth;
    int count;

    // 初始化 : 相当于MAKE-SET(x)
    public DisjointSet(int x) {
        this.count = x;
        this.nodes = new int[x];
        this.depth = new int[x];
        for (int i = 0; i < x; i++) {
            // 初始化时，每个结点都是以自己为单个集合（树）
            nodes[i] = i;
            depth[i] = 1;
        }
    }

    /**
     * UNION(x, y) : 将两个有关系的集合结点合并成一个新集合，相当于说一棵树接到另一棵树
     */
    public void union(int x, int y) {
        // 首先要找到两个结点的根节点（集合代表）
        int xRoot = findSet(x), yRoot = findSet(y);
        // 当根节点都相同时，没有必要继续执行合并
        if (xRoot == yRoot) return;
        // 找到后，如果此时两个结点深度是一致的，则没有要求；否则必须接到深度更深的树上
        if (depth[xRoot] <= depth[yRoot]) nodes[xRoot] = yRoot;
        else nodes[yRoot] = xRoot;
        // 接完后需要是否深度增加，当且仅当两棵树（且为不同结点）深度一样，深度才会加上
        if (depth[xRoot] == depth[yRoot]) depth[yRoot]++; // 因为上面默认深度一样时接到yRoot上，所以是yRoot++
        count--;
    }

    /**
     * FIND-SET(x) : 找到结点x所在集合中的代表（相当于找这棵树的根节点）
     * 所有树高都不会超过 3（union 的时候树高可能达到 3）
     */
    public int findSet(int x) {
        while (nodes[x] != x) {
            nodes[x] = nodes[nodes[x]];
            x = nodes[x];
        }
        return x;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isConnected(int x, int y) {
        return findSet(x) == findSet(y);
    }
}
