import java.util.ArrayList;
import java.util.List;

/**
 * @className: BTreeAllPath
 * @description: 257. 二叉树的所有路径
 * @author: carl
 * @date: 2021/8/17 22:05
 */
public class BTreeAllPath {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    //用于记录路径总数
    List<String> paths = null;
    //用于提高效率
    StringBuilder path = null;

    public List<String> binaryTreePaths(TreeNode root) {
        paths = new ArrayList();
        path = new StringBuilder();
        dfs(root, path);
        return paths;
    }

    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) {
            return;
        }
        //记录此时的索引，方便后面删除
        int temp = path.length();
        path.append(node.val);
        //如果为叶子节点
        if (node.left == null && node.right == null) {
            //添加路径
            paths.add(path.toString());
            //同时删除掉该处位置，防止有左右子节点时，缺少一个->
            path.delete(temp, path.length());
            return;
        }
        path.append("->");
        dfs(node.left, path);
        dfs(node.right, path);
        //叶子节点删除数据后会多->，把这个数据删了
        path.delete(temp, path.length());
    }
}
