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

    HashMap<Integer, Integer> inOrder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != preorder.length) {
            return null;
        }
        inOrder = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            inOrder.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1,
                inOrder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               Map<Integer, Integer> inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // index - 1 - inLeft = x - (preLeft + 1)
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int index = inorder.get(rootVal);

        root.left = buildTree(preorder, preLeft+1, preLeft+index-inLeft, inorder, inLeft, index-1);
        root.right = buildTree(preorder, preLeft+index-inLeft+1, preRight, inorder, index+1, inRight);
        return root;
    }
}