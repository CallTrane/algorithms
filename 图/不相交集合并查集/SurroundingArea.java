package 图.不相交集合并查集;

/**
 * @className: SurroundingArea
 * @description: 130. 被围绕的区域
 * @author: Carl Tong
 * @date: 2022/3/15 1:18
 */
public class SurroundingArea {

    // 并查集
    class DisjointSet {
        int[] nodes;
        int count;

        public DisjointSet(int n) {
            this.nodes = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                nodes[i] = i;
            }
        }

        public void union(int x, int y) {
            int xRoot = findSet(x);
            int yRoot = findSet(y);
            if (xRoot == yRoot) return;
            nodes[xRoot] = yRoot;
            count--;
        }

        public int findSet(int x) {
            if (nodes[x] != x)
                nodes[x] = findSet(nodes[x]);
            return nodes[x];
        }

        public boolean isConnected(int x, int y) {
            return findSet(x) == findSet(y);
        }

        public int getCount() {
            return this.count;
        }
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        // 代表坐标为x * n + y，多出来一个位置dummy用于判断是否为连通
        DisjointSet disjointSet = new DisjointSet(m * n + 1);
        int dummy = m * n;
        // 将最外围的 O 与 dummy 连通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') disjointSet.union(dummy, i * n);
            if (board[i][n - 1] == 'O') disjointSet.union(dummy, i * n + n - 1);
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') disjointSet.union(i, dummy);
            if (board[m - 1][i] == 'O') disjointSet.union((m - 1) * n + i, dummy);
        }
        // 四个方向进行查找
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 开始遍历内层
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    // 对四个方向查找，找到‘O‘的尝试关联
                    for (int[] dire : direction) {
                        int x = dire[0] + i, y = dire[1] + j;
                        if (board[x][y] == 'O') disjointSet.union(x * n + y, i * n + j);
                    }
                }
            }
        }
        // 开始遍历内层
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                // 所有不和 dummy 连通的 O，都要被替换
                if (!disjointSet.isConnected(i * n + j, dummy)) board[i][j] = 'X';
            }
        }
    }
}


