import org.junit.Test;

/**
 * 08题目：找出二叉树中序遍历的下一个节点
 */
public class GetBinaryTreeNext {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {

    }

    public class Solution {

        public TreeNode getNext(TreeNode node) {
            if (node == null) {
                return null;
            }
            TreeNode next = null;
            if (node.right != null) {
                next = node.right;
                while (next.left != null) {
                    next = next.left;
                }
                return next;
            } else if (node.parent != null) {
                next = node.parent;
                if (next.left != node) {
                    while (next != next.parent.left) {
                        next = next.parent;
                    }
                }
                return next;
            }
            return next;
        }
    }

}
