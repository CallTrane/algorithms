package 树.字典树前缀树;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: TrieII
 * @description: 1804. 实现 Trie (前缀树) II
 * @author: Carl Tong
 * @date: 2022/5/11 11:15
 */
public class TrieII {

    private final TrieMap<Integer> TRIE_MAP;

    public TrieII() {
        TRIE_MAP = new TrieMap<>();
    }

    public void insert(String word) {
        if (!TRIE_MAP.containsKey(word)) TRIE_MAP.put(word, 1);
        else TRIE_MAP.put(word, TRIE_MAP.get(word) + 1);
    }

    public int countWordsEqualTo(String word) {
        if (!TRIE_MAP.containsKey(word)) return 0;
        return TRIE_MAP.get(word);
    }

    public int countWordsStartingWith(String word) {
        List<String> keys = TRIE_MAP.keysWithPrefix(word);
        return keys.stream().map(key -> TRIE_MAP.get(key)).reduce(0, (a, b) -> a + b);
    }

    public void erase(String word) {
        int count = TRIE_MAP.get(word);
        if (count == 1) TRIE_MAP.remove(word);
        else TRIE_MAP.put(word, --count);
    }

    private class TrieMap<V> {

        // ASCII码
        private static final int R = 256;

        private TrieNode<V> root = new TrieNode();

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

        private TrieNode<V> put(TrieNode<V> node, int length, String key, V value) {
            if (node == null) node = new TrieNode<>();
            if (length == key.length()) {
                node.value = value;
                return node;
            }
            char c = key.charAt(length);
            node.children[c] = put(node.children[c], length + 1, key, value);
            return node;
        }

        public void remove(String key) {
            root = remove(root, 0, key);
        }

        private TrieNode<V> remove(TrieNode<V> node, int length, String key) {
            if (node == null) return node;
            if (length == key.length()) {
                node.value = null;
            } else {
                char c = key.charAt(length);
                node.children[c] = remove(node.children[c], length + 1, key);
            }
            for (char i = 0; i < R; i++) {
                if (node.children[i] != null) return node;
            }
            return null;
        }

        public boolean containsKey(String key) {
            return get(key) != null;
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
