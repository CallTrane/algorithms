package 图.不相交集合并查集;

/**
 * @className: DisjointSet
 * @description: 不相交集合（并查集）
 * @author: Carl Tong
 * @date: 2022/3/6 19:08
 */
public class DisjointSet {
    // 结点信息，node[i]的值表示第 i 个结点的的根结点（集合元素代表）
    int[] nodes;
    // 使用路径压缩后, 可以不用辅助数组
    int count;

    // 初始化 : 相当于MAKE-SET(x)
    public DisjointSet(int x) {
        this.count = x;
        this.nodes = new int[x];
        for (int i = 0; i < x; i++)
            // 初始化时，每个结点都是以自己为单个集合（树）
            nodes[i] = i;
    }

    /**
     * UNION(x, y) : 将两个有关系的集合结点合并成一个新集合，相当于说一棵树接到另一棵树
     */
    public void union(int x, int y) {
        // 首先要找到两个结点的根节点（集合代表）
        int xRoot = findSet(x), yRoot = findSet(y);
        // 当根节点都相同时，没有必要继续执行合并
        if (xRoot == yRoot) return;
        // 有路径压缩后, 不用深度辅助数组, 直接接到根节点上
        nodes[xRoot] = yRoot;
        count--;
    }

    /**
     * FIND-SET(x) : 找到结点x所在集合中的代表（相当于找这棵树的根节点）
     * 所有树高 <= 2 （在union的时候可能到达3）
     */
    public int findSet(int x) {
        // 直接把该集合所有节点接到根节点下面, 拍平, 此时树深度为2
        if (nodes[x] != x)
            nodes[x] = findSet(nodes[x]);
        return nodes[x];
    }

    public int getCount() {
        return this.count;
    }

    public boolean isConnected(int x, int y) {
        return findSet(x) == findSet(y);
    }
}
