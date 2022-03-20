/**
 * @className: Flatten
 * @description: 114. 二叉树展开为链表
 * @author: Carl Tong
 * @date: 2022/3/16 1:05
 */
public class Flatten {
    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public void flatten(TreeNode root) {
        // 用后续遍历，将每个子树展开后再展开自己
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left, right = root.right;
        // 1、将左子树接到右子树
        root.left = null; root.right = left;
        // 2、将原来的右子树，接到当前右子树的末端上
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
    }
}
