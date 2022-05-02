import java.util.*;

/**
 * @className: BuildTree_3
 * @description: 889. 根据前序和后序遍历构造二叉树
 * @author: Carl Tong
 * @date: 2022/5/2 13:02
 */
public class BuildTree_3 {

    // 题目说二叉树节点的值不存在重复，所以可以使用一个 HashMap 存储元素到索引的映射
    Map<Integer, Integer> valIndex = new HashMap<>();

    /**
     * 通过前序遍历和后续遍历，是无法确定唯一的二叉树的
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length != postorder.length) return null;
        for (int i = 0; i < postorder.length; i++) {
            valIndex.put(postorder[i], i);
        }
        return constructFromPrePost(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode constructFromPrePost(int[] preorder, int preStart, int preEnd,
                                         int[] postorder, int postStart, int postEnd) {
        // 递归终止条件
        if (preStart > preEnd || postStart > postEnd) return null;
        // 如果已经只剩下一个了，直接返回构建结点
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);
        // 确定根的值
        int rootVal = preorder[preStart];
        // 不唯一的点就是在此处，因为不确定该值是不是左子树的根（这里默认作为根）
        int leftRootVal = preorder[preStart + 1];
        // 根据该子树值确定索引位置
        int leftIndex = valIndex.get(leftRootVal);
        // 根据索引处，确定左子树的结点数量
        int leftSize = leftIndex - postStart + 1;
        // 构建
        TreeNode root = new TreeNode(rootVal);
        // 确定范围    (新的preEnd) - (preStart + 1) + 1 = leftSize
        root.left = constructFromPrePost(preorder, preStart + 1, preStart + leftSize, postorder, postStart, leftIndex);
        root.right = constructFromPrePost(preorder, preStart + leftSize + 1, preEnd, postorder, leftIndex + 1, postEnd - 1);
        return root;
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
