/**
 * @className: BTreeSearchDoublyList
 * @description: 剑指 Offer 36. 二叉搜索树与双向链表
 * @author: carl
 * @date: 2021/8/19 14:51
 */
public class BTreeSearchDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        //开始链接
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        //链接操作
        if (pre != null) {
            pre.right = cur;
        //如果pre为空，说明需要初始化head
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
