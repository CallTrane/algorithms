package 树.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @className: 树.二叉树.BTreeBFS
 * @description: 剑指 Offer 32 - I. 从上到下打印二叉树
 * @author: carl
 * @date: 2021/8/19 1:43
 */
public class BTreeBFS {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        //初始化队列存放结点
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        //存放临时数据
        ArrayList<Integer> ans = new ArrayList();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
