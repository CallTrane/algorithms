import java.util.Arrays;
import java.util.LinkedList;

/**
 * @className: Codec
 * @description: 449. 序列化和反序列化二叉搜索树
 * @author: Carl Tong
 * @date: 2022/5/11 22:08
 */
public class Codec {

    private class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            val = x;
        }
    }

    // 分隔符
    private static final String SEP = ",";

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    // 前序遍历序列化
    private void serialize(TreeNode node, StringBuilder builder) {
        if (node == null) return;
        builder.append(node.val).append(SEP);
        serialize(node.left, builder);
        serialize(node.right, builder);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        // 将前序遍历节点存储到列表
        LinkedList<Integer> nodes = new LinkedList<>();
        Arrays.stream(data.split(SEP)).forEach(node -> nodes.add(Integer.parseInt(node)));
        return deserialize(nodes, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private TreeNode deserialize(LinkedList<Integer> nodes, int max, int min) {
        // 如果已经遍历完了
        if (nodes.isEmpty()) return null;
        // 前序遍历 : 第一个为根节点
        int rootVal = nodes.peekFirst();
        // 根据BST性质，如果值超过区间，说明不满足
        if (rootVal < min || rootVal > max) return null;
        nodes.removeFirst();
        // 开始构建
        TreeNode root = new TreeNode(rootVal);
        // 左子树都要比根节点小
        root.left = deserialize(nodes, rootVal, min);
        // 右子树都要比根节点大
        root.right = deserialize(nodes, max, rootVal);
        return root;
    }
}
