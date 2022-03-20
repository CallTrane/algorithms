import java.util.LinkedList;
import java.util.Queue;

/**
 * @className: DeepestLeavesSum
 * @description: 1302. 层数最深叶子节点的和
 * @author: Carl Tong
 * @date: 2022/2/23 16:11
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            res = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}
