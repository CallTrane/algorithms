/**
 * @className: EquationsPossible
 * @description: 990. 等式方程的可满足性
 * @author: Carl Tong
 * @date: 2022/3/15 2:04
 */
public class EquationsPossible {
    // 并查集
    class DisjointSet {
        int count;
        int[] nodes;

        public DisjointSet(int n) {
            this.count = n;
            nodes = new int[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = i;
            }
        }

        public int findSet(int x) {
            while (x != nodes[x]) {
                nodes[x] = nodes[nodes[x]];
                x = nodes[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = findSet(x);
            int yRoot = findSet(y);
            if (xRoot == yRoot) return;
            nodes[xRoot] = yRoot;
            count--;
        }

        public int getCount() {
            return this.count;
        }

        public boolean isConnected(int x, int y) {
            return findSet(x) == findSet(y);
        }

    }

    public boolean equationsPossible(String[] equations) {
        // 26个小写字母
        DisjointSet disjointSet = new DisjointSet(26);
        // 把==的，当作一个集合连通
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                int x = s.charAt(0) - 'a', y = s.charAt(3) - 'a';
                disjointSet.union(x, y);
            }
        }
        // 找到!=的，判断两个是不是连通，如果连通的话就违反
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                int x = s.charAt(0) - 'a', y = s.charAt(3) - 'a';
                if (disjointSet.isConnected(x, y)) return false;
            }
        }
        return true;
    }
}
