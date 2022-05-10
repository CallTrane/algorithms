/**
 * @className: WordDictionary
 * @description: 211. 添加与搜索单词 - 数据结构设计
 * @author: Carl Tong
 * @date: 2022/5/10 22:54
 */
public class WordDictionary {

    private final TrieSet TRIE_SET;

    public WordDictionary() {
        TRIE_SET = new TrieSet();
    }

    public void addWord(String word) {
        TRIE_SET.add(word);
    }

    public boolean search(String word) {
        return TRIE_SET.hasKeyWithPattern(word);
    }

    private class TrieMap<V> {

        // 这里不能用ASCII码，会超时。所以只用保存26个字母
        private static final int R = 26;

        // 通配符
        private static final char WILD_CARD = '.';

        private TrieNode<V> root = new TrieNode<>();

        private class TrieNode<V> {
            V value;
            TrieNode[] children;

            public TrieNode() {
                children = new TrieNode[R];
            }
        }

        public void put(String key, V value) {
            root = put(root, 0, key, value);
        }

        private TrieNode<V> put(TrieNode<V> node, int index, String key, V value) {
            if (node == null) node = new TrieNode<>();
            if (index == key.length()) {
                node.value = value;
                return node;
            }
            int i = key.charAt(index) - 'a';
            node.children[i] = put(node.children[i], index + 1, key, value);
            return node;
        }

        public boolean hasKeyWithPattern(String pattern) {
            return hasKeyWithPattern(root, 0, pattern);
        }

        private boolean hasKeyWithPattern(TrieNode<V> node, int index, String pattern) {
            if (node == null) return false;
            if (index == pattern.length()) return node.value != null;
            char c = pattern.charAt(index);
            if (c != WILD_CARD) return hasKeyWithPattern(node.children[c - 'a'], index + 1, pattern);
            for (int i = 0; i < R; i++) {
                if (hasKeyWithPattern(node.children[i], index + 1, pattern)) return true;
            }
            return false;
        }
    }

    private class TrieSet<V> {
        private final TrieMap<V> TRIE_MAP;

        public TrieSet() {
            TRIE_MAP = new TrieMap<>();
        }

        public void add(String key) {
            TRIE_MAP.put(key, (V) new Object());
        }

        public boolean hasKeyWithPattern(String pattern) {
            return TRIE_MAP.hasKeyWithPattern(pattern);
        }
    }
}
