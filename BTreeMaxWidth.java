import java.util.HashMap;

/**
 * @className: BTreeMaxWidth
 * @description: TODO
 * @author: carl
 * @date: 2021/9/9 0:13
 */
public class BTreeMaxWidth {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    HashMap<Integer, Integer> left;
    int result;

    public int widthOfBinaryTree(TreeNode root) {
        left = new HashMap();
        result = 0;
        dfs(root, 0, 0);
        return result;
    }

    void dfs(TreeNode node, int depth, int position) {
        if (node == null) {
            return;
        }
        left.computeIfAbsent(depth, x -> position);
        result = Math.max(result, position-left.get(depth)+1);
        dfs(node.left, depth+1, 2*position);
        dfs(node.right, depth+1, 2*position+1);
    }
}
