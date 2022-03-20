import org.junit.Test;

import java.util.HashMap;

/**
 * 07：重建二叉树
 */
public class RebuildBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        int[] preOrder = new int[]{1,2,4,7,3,5,6,8};
        int[] inOrder = new int[]{4,7,2,1,5,3,8,6};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(preOrder, inOrder);
    }

    public class Solution {
        HashMap<Integer, Integer> map = new HashMap();
        int preOrder[];
        
        public TreeNode buildTree(int[] preOrder, int[] inOrder) {
            this.preOrder = preOrder;
            for (int i = 0; i < inOrder.length; i++) {
                map.put(inOrder[i], i);
            }
            return recur(0, 0, inOrder.length - 1);
        }

        private TreeNode recur(int preOrderIndex, int borderLeft, int borderRight) {
            if (borderLeft > borderRight) {
                return null;
            }
            TreeNode root = new TreeNode(preOrder[preOrderIndex]);
            int index = map.get(preOrder[preOrderIndex]);
            root.left = recur(preOrderIndex + 1, borderLeft, index - 1);
            root.right = recur(preOrderIndex + (index - borderLeft) + 1, index + 1, borderRight);

            return root;
        }
    }


}
