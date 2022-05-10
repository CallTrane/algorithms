import java.util.List;

/**
 * @className: ReplaceWords
 * @description: 648. 单词替换
 * @author: Carl Tong
 * @date: 2022/5/10 20:46
 */
public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieSet trieSet = new TrieSet();
        dictionary.forEach(word -> trieSet.add(word));
        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            String s = trieSet.shortestPrefixOf(word);
            if (!s.isEmpty()) builder.append(s);
            else builder.append(word);
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    private class TrieMap<V> {

        // ASCII码
        private static final int R = 256;

        private TrieNode<V> root = new TrieNode<>();

        class TrieNode<V> {
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
            char c = key.charAt(index);
            node.children[c] = put(node.children[c], index + 1, key, value);
            return node;
        }

        // 返回存在键的最短前缀
        public String shortestPrefixOf(String prefix) {
            TrieNode<V> p = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (p == null) return "";
                if (p.value != null) return prefix.substring(0, i);
                char c = prefix.charAt(i);
                p = p.children[c];
            }
            // 最后还要判断一次树枝和节点
            if (p == null || p.value == null) return "";
            return prefix;
        }


    }

    private class TrieSet<V> {
        private TrieMap<V> TRIE_MAP;

        public TrieSet() {
            TRIE_MAP = new TrieMap<>();
        }

        public void add(String word) {
            TRIE_MAP.put(word, (V) new Object());
        }

        private String shortestPrefixOf(String prefix) {
            return TRIE_MAP.shortestPrefixOf(prefix);
        }

    }
}
