/**
 * @className: ConstructMaximumBinaryTree
 * @description: 654. 最大二叉树
 * @author: Carl Tong
 * @date: 2022/4/28 11:44
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) return null;
        int index = -1, val = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (nums[i] > val) {
                val = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(val);
        node.left = build(nums, low, index - 1);
        node.right = build(nums, index + 1, high);
        return node;
    }


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
}
