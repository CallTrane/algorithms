import java.util.HashMap;
import java.util.Map;

/**
 * @className: BuildTree_2
 * @description: 106. 从中序与后序遍历序列构造二叉树
 * @author: carl
 * @date: 2021/9/12 15:17
 */
public class BuildTree_2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 题目说二叉树节点的值不存在重复，所以可以使用一个 HashMap 存储元素到索引的映射
    Map<Integer, Integer> inOrderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        // 存储中序遍历的索引
        inOrderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndex.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                               int[] postorder, int postStart, int postEnd) {
        // 递归终止条件
        if (inStart > inEnd || postStart > postEnd) return null;
        // 确定根的值
        int rootVal = postorder[postEnd];
        // 中序遍历中的索引位
        int index = inOrderIndex.get(rootVal);
        // 右子树的节点数量
        int rightSize = inEnd - index;
        // 构建
        TreeNode root = new TreeNode(rootVal);
        // 确定范围
        root.right = buildTree(inorder, index + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);
        root.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postEnd - rightSize - 1);
        return root;
    }

}
