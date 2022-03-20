import java.util.LinkedList;
import java.util.Queue;

/**
 * @className: IsUnivalTree
 * @description: 965. 单值二叉树
 * @author: Carl Tong
 * @date: 2022/2/23 16:18
 */
public class IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int common = root.val;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val != common) return false;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return true;
    }
}
