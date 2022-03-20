/**
 * @className: BSearchTreeRecentAncestors
 * @description: 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * @author: carl
 * @date: 2021/8/24 16:39
 */
/*public class BSearchTreeRecentAncestors {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //保证p小于q
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (root != null) {
            //如果p < q < root，则查找左子树
            if (q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}*/
