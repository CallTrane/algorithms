package 树.二叉搜索树;

/**
 * @className: InorderSuccessor
 * @description: 面试题 04.06. 后继者
 * @author: Carl Tong
 * @date: 2022/5/16 10:56
 */
public class InorderSuccessor {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int val) {
            this.val = val;
        }
    }

    // 二叉搜索树的一个性质是 中序遍历 序列单调递增，因此二叉搜索树中的节点 p 的后继节点满足以下条件：
    // 后继节点是节点值大于 p 的节点值的所有节点中节点值最小的一个节点。
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        // 如果 p 有右子树，则后继节点为右子树的【左下方】的节点
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) successor = successor.left;
        // 否则，后继节点为 p 最近的祖先节点，且该节点需大于 p
        } else {
            // 从根节点开始遍历寻找节点 p 的祖先节点
            TreeNode node = root;
            while (node != null) {
                // node 的节点值大于 p 的节点值，则 p 的后继节点可能是 node 或者在 node 的左子树中
                if (node.val > p.val) {
                    // 当且仅当 node.val > p.val 时，才更新后继节点
                    successor = node;
                    node = node.left;
                //  否则，node 的节点值小于或等于 p 的节点值，则 p 的后继节点可能在 node 的右子树中
                } else {
                    node = node.right;
                }
            }
        }
        return successor;
    }

}
