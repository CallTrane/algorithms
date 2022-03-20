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

    HashMap<Integer, Integer> inOrder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        inOrder = new HashMap() ;
        for (int i = 0; i < inorder.length; i++) {
            inOrder.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length-1,
                inOrder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight,
                               Map<Integer, Integer> inOrder, int inLeft, int inRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        //inRight - (index+1) = (postRight-1) - x
        int index = inOrder.get(rootVal);
        root.left = buildTree(postorder, postLeft, postRight+index-inRight-1, inOrder, inLeft, index-1);
        root.right = buildTree(postorder, postRight+index-inRight, postRight-1, inOrder, index+1, inRight);
        return root;
    }
}
