import java.util.*;

/**
 * @className: GetAllElements
 * @description: 1305. 两棵二叉搜索树中的所有元素
 * @author: Carl Tong
 * @date: 2022/5/1 11:34
 */
public class GetAllElements {

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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> container1 = new ArrayList<>();
        List<Integer> container2 = new ArrayList<>();
        pushElement(container1, root1);
        pushElement(container2, root2);
        List<Integer> res = new ArrayList<>(container1.size() + container2.size());
        int n = 0, m = 0;
        while (n < container1.size() && m < container2.size()) {
            if (container1.get(n) < container2.get(m)) res.add(container1.get(n++));
            else res.add(container2.get(m++));
        }
        // 把另外一棵树的剩余元素加上
        while (n < container1.size()) res.add(container1.get(n++));
        while (m < container2.size()) res.add(container2.get(m++));
        return res;
    }

    private void pushElement(List<Integer> container, TreeNode root) {
        if (root == null) return;
        pushElement(container, root.left);
        container.add(root.val);
        pushElement(container, root.right);
    }

}
