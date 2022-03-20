/**
 * @className: TreeNode
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/2/23 15:47
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
