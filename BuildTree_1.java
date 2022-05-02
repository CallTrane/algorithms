import java.util.HashMap;
import java.util.Map;

/**
 * @className: BuildTree_1
 * @description: 105. 从前序与中序遍历序列构造二叉树
 * @author: carl
 * @date: 2021/9/12 11:55
 */
public class BuildTree_1 {

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
    Map<Integer, Integer> inOrderIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 存储中序遍历的索引
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndex.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd) {
        // 递归终止条件
        if (preStart > preEnd || inStart > inEnd) return null;
        // 确定根的值
        int rootVal = preorder[preStart];
        // 在中序遍历中的索引位置
        int index = inOrderIndex.get(rootVal);
        // 左子树的节点数
        int leftSize = index - inStart;
        // 构建
        TreeNode root = new TreeNode(rootVal);
        // 根据上面计算的左子树节点数，规划范围
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

}