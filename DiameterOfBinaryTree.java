/**
 * @className: DiameterOfBinaryTree
 * @description: 543. 二叉树的直径
 * @author: Carl Tong
 * @date: 2022/3/15 21:53
 */
public class DiameterOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    int res = 0;
    // 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        // 后序遍历计算直径，因为后序遍历可以获取左右子树数据
        int d = leftDepth + rightDepth;
        res = Math.max(res, d);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
