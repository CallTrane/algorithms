package 树.字典树前缀树;

/**
 * @className: Trie
 * @description: 208. 实现 Trie (前缀树)
 * @author: Carl Tong
 * @date: 2022/5/10 10:51
 */
public class Trie<V> {

    private final TrieSet<V> TRIE_SET;

    public Trie() {
        TRIE_SET = new TrieSet<>();
    }

    public void insert(String word) {
        TRIE_SET.add(word);
    }

    public boolean search(String word) {
        return TRIE_SET.get(word) != null;
    }

    public boolean startsWith(String prefix) {
        return TRIE_SET.hasKeyWithPrefix(prefix);
    }

    private class TrieMap<V> {
        // ASCII码
        private static final int R = 256;

        private TrieNode<V> root = null;

        private class TrieNode<V> {
            V value = null;
            TrieNode[] children = new TrieNode[R];
        }

        // 沿着前缀(树枝)搜索键节点
        private TrieNode<V> getNode(TrieNode<V> node, String prefix) {
            TrieNode<V> p = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (p == null) return null;
                char c = prefix.charAt(i);
                p = p.children[c];
            }
            return p;
        }

        // 获取键的value
        public V get(String key) {
            TrieNode<V> node = getNode(root, key);
            if (node == null || node.value == null) return null;
            return node.value;
        }

        public void put(String key, V value) {
            root = put(root, 0, key, value);
        }

        // 辅助函数：递归插入
        private TrieNode<V> put(TrieNode<V> node, int index, String key, V value) {
            // 如果没有前缀（树枝），则新建
            if (node == null) node = new TrieNode<>();
            // 如果已经找到需要插入的结点
            if (index == key.length()) {
                node.value = value;
                return node;
            }
            // 寻找下一前缀
            char c = key.charAt(index);
            node.children[c] = put(node.children[c], index + 1, key, value);
            // 返回根结点
            return node;
        }

        // 判断是否有前缀（树枝）
        public boolean hasKeyWithPrefix(String prefix) {
            return getNode(root, prefix) != null;
        }
    }

    private class TrieSet<V> {
        private final TrieMap<V> TRIE_MAP = new TrieMap<>();

        public void add(String key) {
            TRIE_MAP.put(key, (V) new Object());
        }

        public V get(String key) {
            return TRIE_MAP.get(key);
        }

        public boolean hasKeyWithPrefix(String prefix) {
            return TRIE_MAP.hasKeyWithPrefix(prefix);
        }
    }
}
