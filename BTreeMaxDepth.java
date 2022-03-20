import org.junit.Test;

/**
 * @className: BTreeMaxDepth
 * @description: TODO
 * @author: carl
 * @date: 2021/8/20 22:02
 */

public class BTreeMaxDepth {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int result = 0;
    public int maxDepth(TreeNode root) {
        if (root != null) {
            dfs(root, 0);
        }
        return result;
    }
    void dfs(TreeNode node, int depth) {
        if (node == null) {
            result = Math.max(result, depth);
            return;
        }
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }

}

