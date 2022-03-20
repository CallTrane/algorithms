import java.util.ArrayList;
import java.util.HashMap;
/**
 * @className: TencentMusic
 * @description: TODO
 * @author: carl
 * @date: 2021/9/16 19:06
 */
public class TencentMusic {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    HashMap<Integer, ArrayList<TreeNode>> nums; // 存放每一层的节点
    HashMap<Integer, Integer> index; //深度 -- 索引起始

    /*public TreeNode cyclicShiftTree (TreeNode root, int k) {
        nums = new HashMap();
        addNode(root, 0);
    }*/

    public void recur(TreeNode left, TreeNode right, int count, int depth) {
        ArrayList<TreeNode> array;
        if (nums.containsKey(depth)) {
            array = nums.get(depth);
        } else {
            return;
        }
        int now = 0;
        if (index.containsKey(depth)) {
            now = index.get(depth);
        }



        /*recur(left, );*/
    }

    public void addNode(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        ArrayList<TreeNode> array;
        if (nums.containsKey(depth)) {
            array = nums.get(depth);
        } else {
            array = new ArrayList();
            nums.put(depth, array);
        }
        array.add(node);
        addNode(node.left, depth+1);
        addNode(node.right, depth+1);
    }




}
