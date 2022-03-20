/**
 * @className: Connect
 * @description: 116. 填充每个节点的下一个右侧节点指针
 * @author: Carl Tong
 * @date: 2022/3/16 1:01
 */
public class Connect {

    class Node {
        int cal;
        Node left, right, next;
    }

    public Node connect(Node root) {
        if (root == null) return null;
        connect(root.left, root.right);
        return root;
    }

    private void connect(Node left, Node right) {
        if (left == null || right == null) return;
        left.next = right;
        connect(left.left, left.right);
        connect(right.left, right.right);
        // 连接不同父节点的子节点
        connect(left.right, right.left);
    }
}
