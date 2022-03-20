import java.util.Deque;
import java.util.LinkedList;

/**
 * @className: MinDepth
 * @description: 111. 二叉树的最小深度
 * @author: Carl Tong
 * @date: 2022/3/14 13:48
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cur = queue.size();
            for (int i = 0; i < cur; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
