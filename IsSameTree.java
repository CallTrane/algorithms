import java.util.LinkedList;
import java.util.Queue;

/**
 * @className: IsSameTree
 * @description: 100. 相同的树
 * @author: Carl Tong
 * @date: 2022/2/23 2:10
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.offer(p);
        queueQ.offer(q);
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();
            if (nodeP.val != nodeQ.val) return false;
            TreeNode leftP = nodeP.left; TreeNode rightP = nodeP.right;
            TreeNode leftQ = nodeQ.left; TreeNode rightQ = nodeQ.right;
            if (leftP == null ^ leftQ == null) return false;
            if (rightP == null ^ rightQ == null) return false;
            if (leftP != null) queueP.offer(leftP);
            if (leftQ != null) queueQ.offer(leftQ);
            if (rightP != null) queueP.offer(rightP);
            if (rightQ != null) queueQ.offer(rightQ);
        }
        return queueP.isEmpty() && queueQ.isEmpty();
    }
}
