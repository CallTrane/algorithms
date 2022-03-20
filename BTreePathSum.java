import java.util.LinkedList;
import java.util.List;

/**
 * @className: BTreePathSum
 * @description: 剑指 Offer 34. 二叉树中和为某一值的路径
 * @author: carl
 * @date: 2021/8/20 20:07
 */
public class BTreePathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> result = new LinkedList();
    LinkedList<Integer> path = new LinkedList();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return result;
    }

    private void recur(TreeNode node, int num) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        num -= node.val;
        if (num == 0 && node.left == null && node.right == null) {
            //复制了一个 path 并加入到 result 中，不然直接传入会随着path改变而改变
            result.add(new LinkedList(path));
        }
        recur(node.left, num);
        recur(node.right, num);
        //向上回溯，结点需要从路径中删除
        path.removeLast();
    }
}
