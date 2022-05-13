import java.util.ArrayList;
import java.util.List;

/**
 * @className: MapSum
 * @description: 677. 键值映射
 * @author: Carl Tong
 * @date: 2022/5/13 1:49
 */
public class MapSum {

    private final TrieMap<Integer> TRIE_MAP;

    public MapSum() {
        TRIE_MAP = new TrieMap();
    }

    public void insert(String key, int val) {
        TRIE_MAP.put(key, val);
    }

    public int sum(String prefix) {
        List<String> keys = TRIE_MAP.keysWithPrefix(prefix);
        return keys.stream().mapToInt(key -> TRIE_MAP.get(key)).sum();
    }

    private class TrieMap<V> {
        private static final int R = 256;

        private TrieNode<V> root = new TrieNode<>();

        private class TrieNode<V> {
            V value;
            TrieNode[] children;

            public TrieNode() {
                children = new TrieNode[R];
            }
        }

        private TrieNode<V> getNode(TrieNode<V> node, String key) {
            TrieNode<V> p = node;
            for (int i = 0; i < key.length(); i++) {
                if (p == null) return null;
                char c = key.charAt(i);
                p = p.children[c];
            }
            return p;
        }

        public V get(String key) {
            TrieNode<V> node = getNode(root, key);
            if (node == null || node.value == null) return null;
            return node.value;
        }

        public void put(String key, V value) {
            root = put(root, 0, key, value);
        }

        private TrieNode put(TrieNode<V> node, int length, String key, V value) {
            if (node == null) node = new TrieNode<>();
            if (length == key.length()) {
                node.value = value;
                return node;
            }
            char c = key.charAt(length);
            node.children[c] = put(node.children[c], length + 1, key, value);
            return node;
        }

        public List<String> keysWithPrefix(String prefix) {
            List<String> res = new ArrayList<>();
            TrieNode<V> node = getNode(root, prefix);
            if (node != null) keysWithPrefix(node, new StringBuilder(prefix), res);
            return res;
        }

        private void keysWithPrefix(TrieNode<V> node, StringBuilder path, List<String> res) {
            if (node == null) return;
            if (node.value != null) res.add(path.toString());
            for (char i = 0; i < R; i++) {
                path.append(i);
                keysWithPrefix(node.children[i], path, res);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
