import java.util.ArrayList;
import java.util.List;

/**
 * @className: TrieMap
 * @description: 字典树（前缀树） 要求键的类型K必须是「可比较」的 （有前缀不一定有值）
 * @author: Carl Tong
 * @date: 2022/5/9 17:43
 */
public class TrieMap<V> {

    // ASCII码 个数
    private static final int R = 256;

    // 通配符
    private static final char WILD_CARD = '.';

    // 当前 TrieMap 中键的个数
    private int size = 0;

    public int size() {
        return size;
    }

    /**
     * TrieNode 对象是作为前缀（树枝）
     */
    public static class TrieNode<V> {
        // value 作为键（结点）
        V value = null;
        // 字符是通过子节点在父节点的children数组中的索引确定的，作为前缀（树枝）
        TrieNode[] children = new TrieNode[R];
    }

    // Trie树的根节点
    private TrieNode<V> root = null;

    /**
     * 工具函数 : 从节点 node 开始搜索前缀(树枝)，如果存在返回对应节点，否则返回 null
     */
    private TrieNode<V> getNode(TrieNode<V> node, String prefix) {
        TrieNode<V> p = node;
        // 对每个字符进行匹配
        for (int i = 0; i < prefix.length(); i++) {
            // 如果为null，则无法向下搜索
            if (p == null) return null;
            // 否则，继续向下搜索
            char c = prefix.charAt(i);
            p = p.children[c];
        }
        return p;
    }

    // ======================= API ==============================

    /**
     * 在 Map 中添加 key
     *
     * @param key   键
     * @param value 值
     */
    public void put(String key, V value) {
        if (!containsKey(key)) size++;
        // 需要一个额外的辅助函数，递归修改数据结构
        root = put(root, 0, key, value);
    }

    /**
     * 辅助函数：向以 node 为根的 Trie 树中插入 key[i..]，返回插入完成后的根节点
     *
     * @param node   前缀（树枝）
     * @param length 长度
     * @param key    键（结点）
     * @param value  值
     * @return 根节点
     */
    private TrieNode<V> put(TrieNode<V> node, int length, String key, V value) {
        // 如果前缀（树枝）不存在，则新建
        if (node == null) node = new TrieNode<>();
        // 如果长度相等了，说明插入完成，将 value 存入键（结点）中
        if (length == key.length()) {
            node.value = value;
            return node;
        }
        char c = key.charAt(length);
        // 递归插入子节点，接收返回值根节点
        node.children[c] = put(node.children[c], length + 1, key, value);
        // 返回插入完成后的根节点
        return node;
    }

    /**
     * 删除键 key 以及对应的值 <br>
     * ps : 一个节点如果自己的value字段是否为空，以及自己的children数组（全部前缀树枝）全都是空指针，则自己也要被删除
     *
     * @param key 键
     */
    public void remove(String key) {
        if (!containsKey(key)) return;
        root = remove(root, 0, key);
        size--;
    }

    /**
     * 辅助函数 : 在以 node 为根的 Trie 树中删除 key[i..]，返回删除后的根节点
     *
     * @param node   前缀（树枝）
     * @param length 长度
     * @param key    键（结点）
     * @return 根节点
     */
    private TrieNode<V> remove(TrieNode<V> node, int length, String key) {
        // 如果前缀（树枝）不存在，说明匹配失败查找不到该 key，直接终止
        if (node == null) return null;
        // 如果找到了key（键结点）对应的TrieNode（前缀树枝），则删除该树枝的 value
        if (length == key.length()) {
            node.value = null;
        }
        // 否则，则继续递归子树，寻找键删除
        else {
            char c = key.charAt(length);
            node.children[c] = remove(node.children[c], length + 1, key);
        }
        // （后续遍历）删除完之后，判断自己是否还存在前缀（树枝）
        for (char i = 0; i < R; i++) {
            // 如果存在一个前缀（树枝），则自己不能被删除，直接返回
            if (node.children[i] != null) return node;
        }
        // 既没有存储 val，也没有后缀树枝，则该节点需要被清理
        return null;
    }

    /**
     * 获取 key 对应的值，不存在则返回 null
     *
     * @param key 键
     */
    public V get(String key) {
        // 从 root 开始搜索键（结点）
        // 需要注意，就算 getNode(key) 的返回值 node 非空，也只能说字符串 key 是一个「前缀」；除非 node.value 同时非空，才能判断键 key 存在（也就是说，有前缀不一定有key）
        TrieNode<V> node = getNode(root, key);
        // 如果 node 为空（没有前缀）或者 value 字段为空（没有结点），说明没有对应的键（结点，即key）
        if (node == null || node.value == null) return null;
        return node.value;
    }

    /**
     * 判断 key 是否存在 TrieMap 中
     *
     * @param key 键
     */
    public boolean containsKey(String key) {
        // 有前缀不一定有 key
        return get(key) != null;
    }

    /**
     * 判断是否存在前缀为 prefix
     */
    public boolean hasKeyWithPrefix(String prefix) {
        // 这里是只判断是否存在前缀，不是key（区别于containsKey）
        return getNode(root, prefix) != null;
    }

    /**
     * 搜索所有前缀为 prefix 的键
     */
    public List<String> keysWithPrefix(String prefix) {
        List<String> res = new ArrayList<>();
        // 先找到该前缀的结点
        TrieNode<V> node = getNode(root, prefix);
        // 结点不为空，说明存在该前缀，回溯遍历所有字符（否则跳过，返回结束）
        if (node != null) traverse(node, new StringBuilder(prefix), res);
        return res;
    }

    private void traverse(TrieNode<V> node, StringBuilder path, List<String> res) {
        // 不存在该结点（前缀），直接结束
        if (node == null) return;
        // 结点（前缀）存在，且键存在，添加进答案
        if (node != null) res.add(path.toString());
        // 回溯遍历所有树枝字符
        for (char c = 0; c < R; c++) {
            // 添加选择（字符）
            path.append(c);
            // 继续回溯遍历
            traverse(node.children[c], path, res);
            // 撤回选择（字符）
            path.deleteCharAt(path.length() - 1);
        }
    }


    /**
     * 搜索所有匹配的键
     * 通配符. 匹配任意字符
     * <p>
     * For example : keysWithPattern("t.a.") -> ["team", "that"]
     * </P>
     */
    public List<String> keysWithPattern(String pattern) {
        List<String> res = new ArrayList<>();
        traverse(root, new StringBuilder(), pattern, 0, res);
        return res;
    }

    private void traverse(TrieNode<V> node, StringBuilder path, String pattern, int length, List<String> res) {
        // 如果不存在该前缀（树枝），匹配失败回溯终止
        if (node == null) return;
        // 如果长度已经达到 pattern，也是回溯终止条件之一
        if (length == pattern.length()) {
            // 判断当前键（结点）是否存在，如果存在说明是答案之一
            if (node.value != null) res.add(path.toString());
            return;
        }
        // 当前字符
        char c = path.charAt(length);
        // 如果是通配符，回溯遍历所有树枝
        if (c == WILD_CARD) {
            for (char i = 0; i < R; i++) {
                path.append(i);
                traverse(node.children[i], path, pattern, length + 1, res);
                path.deleteCharAt(path.length() - 1);
            }
            // 否则，是普通字符
        } else {
            path.append(c);
            traverse(node.children[c], path, pattern, length + 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    /**
     * 通配符. 匹配任意字符
     * 判断是否存在匹配的键
     * <p>
     * For example : if TrieMap has the key for zip <br>
     * hasKeyWithPattern(".ip") -> true <br>
     * hasKeyWithPattern(".i") -> false
     * </P>
     */
    public boolean hasKeyWithPattern(String pattern) {
        return hasKeyWithPattern(root, pattern, 0);
    }

    private boolean hasKeyWithPattern(TrieNode<V> node, String pattern, int length) {
        // 如果没有前缀（树枝），说明匹配失败
        if (node == null) return false;
        // 如果长度匹配成功，判断是否是一个键（结点）
        if (length == pattern.length()) return node.value != null;
        // 开始匹配
        char c = pattern.charAt(length);
        // 如果不是通配符，直接进行下一匹配
        if (c != WILD_CARD) return hasKeyWithPattern(node.children[c], pattern, length + 1);
        // 否则是通配符，则对每个字符进行匹配
        for (int i = 0; i < R; i++) {
            // 如果存在一个字符成功匹配，则直接返回 true
            if (hasKeyWithPattern(node.children[i], pattern, length + 1)) return true;
        }
        return false;
    }

    /**
     * 在 Map 的所有键中搜索 query 的最短前缀
     */
    public String shortestPrefixOf(String query) {
        TrieNode<V> p = root;
        for (int i = 0; i < query.length(); i++) {
            // 结点为空，没有前缀，无法继续向下搜索
            if (p == null) return "";
            // 存在结点有前缀，要根据字段判断是否存在键
            if (p.value != null) return query.substring(0, i);
            // 有前缀没键，继续向下搜索
            char c = query.charAt(i);
            p = p.children[c];
        }
        // 最后一次判断 : query本身是不是键 （Trie 树中「树枝」存储字符串，「节点」存储字符串对应的值，for 循环相当于只遍历了「树枝」，但漏掉了最后一个「节点」）
        if (p != null && p.value != null) return query;
        return "";
    }

    /**
     * 在 Map 的所有键中搜索 query 的最长前缀
     */
    public String longestPrefixOf(String query) {
        TrieNode<V> p = root;
        int maxLength = 0;
        for (int i = 0; i < query.length(); i++) {
            // 无法继续向下搜索
            if (p == null) break;
            // 存在键，更新最大值
            if (p.value != null) maxLength = i;
            // 继续向下搜索
            char c = query.charAt(i);
            p = p.children[c];
        }
        // 最后一次判断 : query本身是不是键 （Trie 树中「树枝」存储字符串，「节点」存储字符串对应的值，for 循环相当于只遍历了「树枝」，但漏掉了最后一个「节点」）
        if (p != null && p.value != null) return query;
        return query.substring(0, maxLength);
    }

}

class TrieSet {
    // 底层用一个 TrieMap，键就是 TrieSet，值仅仅起到占位的作用
    // 值的类型可以随便设置，参考 Java 标准库设置成 Object
    private final TrieMap<Object> map = new TrieMap<>();

    /***** 增 *****/

    // 在集合中添加元素 key
    public void add(String key) {
        map.put(key, new Object());
    }

    /***** 删 *****/

    // 从集合中删除元素 key
    public void remove(String key) {
        map.remove(key);
    }

    /***** 查 *****/

    // 判断元素 key 是否存在集合中
    public boolean contains(String key) {
        return map.containsKey(key);
    }

    // 在集合中寻找 query 的最短前缀
    public String shortestPrefixOf(String query) {
        return map.shortestPrefixOf(query);
    }

    // 在集合中寻找 query 的最长前缀
    public String longestPrefixOf(String query) {
        return map.longestPrefixOf(query);
    }

    // 在集合中搜索前缀为 prefix 的所有元素
    public List<String> keysWithPrefix(String prefix) {
        return map.keysWithPrefix(prefix);
    }

    // 判断集合中是否存在前缀为 prefix 的元素
    public boolean hasKeyWithPrefix(String prefix) {
        return map.hasKeyWithPrefix(prefix);
    }

    // 通配符 . 匹配任意字符，返回集合中匹配 pattern 的所有元素
    public List<String> keysWithPattern(String pattern) {
        return map.keysWithPattern(pattern);
    }

    // 通配符 . 匹配任意字符，判断集合中是否存在匹配 pattern 的元素
    public boolean hasKeyWithPattern(String pattern) {
        return map.hasKeyWithPattern(pattern);
    }

    // 返回集合中元素的个数
    public int size() {
        return map.size();
    }
}