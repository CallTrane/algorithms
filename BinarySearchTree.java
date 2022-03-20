/**
 * @className: BinarySearchTree
 * @description: 二叉搜索树、二叉搜索树的基本操作时间复杂度为O(h)
 * @author: Carl Tong
 * @date: 2022/1/25 11:24
 */
public class BinarySearchTree {

    /**
     * 生成二叉搜索树
     *
     * @return
     */
    private static TreeNode generateBST() {
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, one, three);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode six = new TreeNode(6, five, seven);
        TreeNode root = new TreeNode(4, two, six);
        return root;
    }

    // 1、递归

    // 2、非递归，使用栈

    /**
     * 3、非递归，不用栈只用两个辅助指针（时间复杂度O(n)、空间复杂度O(1)）
     * <p>
     * 我们可以暂时使用B节点右子树的链接，存储后继节点，以实现对后继节点的直接获取，同时不占用额外的空间。这就是Morris遍历算法的主要思想。
     */
    public static void morrisInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root, pre = null;
        while (cur != null) {
            // 如果当前结点的左子树为空，根据中序遍历规则，转移到右子树继续遍历（如果是没有右子树的，则是后继结点，此时代表后继结点的左子树全部遍历完毕）
            if (cur.left == null) {
                System.out.println(cur.val);
                cur = cur.right;
                // 否则，则开始确定左子树中的前驱结点
            } else {
                pre = cur.left;
                // 通过while循环，找到当前结点的前驱（左子树的最右结点）
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // 如果前驱结点的右指针为空，则证明还没有访问过；链接好前驱结点后，继续往左子树找
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                    // 否则，右指针为当前结点，则证明当前结点的左子树已经遍历完毕，需要恢复结构，同时进入到右子树
                } else {
                    pre.right = null;
                    System.out.println(cur.val);
                    cur = cur.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = generateBST();
        morrisInOrder(root);
        System.out.println(maximum(root).val);
        System.out.println(minimum(root).val);
        System.out.println(search(root, 3).val);
    }

    /**
     * 时间复杂度O(h)
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode search(TreeNode root, int key) {
        if (root == null || root.val == key) {
            return root;
        }
        if (root.val > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    /**
     * 时间复杂度O(h)
     *
     * @param root
     * @param newNode
     */
    public static void insert(TreeNode root, TreeNode newNode) {
        // 如果是空树
        if (root == null) {
            root = newNode;
            return;
        }
        // 遍历指针、以及保存父节点
        TreeNode tmp = root, parent = null;
        // 指针向下移动，直到找到null的结点，该结点就是要插入的位置
        while (tmp != null) {
            parent = tmp;
            // 如果新插入的结点小，就要往左子树找；否则同理
            if (newNode.val < tmp.val) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        // 链接结点
        newNode.parent = parent;
        if (newNode.val < parent.val) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public static void delete(TreeNode deleteNode) {
        // 如果左右孩子都为空，则直接删除；有任一为空，用不为空的另外子结点替代
        if (deleteNode.left == null) {
            transPlant(deleteNode, deleteNode.right);
        } else if (deleteNode.right == null) {
            transPlant(deleteNode, deleteNode.left);
            // 如果都不为空的情况
        } else {
            // 找到右子树中最小的结点（即删除结点的后继结点，此时该结点是没有左子树的）
            TreeNode successor = minimum(deleteNode.right);
            // 用新结点替代后，更新指针
            transPlant(deleteNode, successor);
            successor.left = deleteNode.left;
            deleteNode.left.parent = successor;
            // 如果这个结点不是删除结点的右孩子，则还要更新替代结点以及删除的右子树相关指针
            if (successor.parent != deleteNode) {
                transPlant(successor, successor.right);
                successor.right = deleteNode.right;
                deleteNode.right.parent = successor;
            }
        }
    }

    /**
     * 新节点替代旧结点（旧结点自身的指针不会变化）
     *
     * @param oldNode
     * @param newNode
     */
    public static void transPlant(TreeNode oldNode, TreeNode newNode) {
        // 如果是空结点的情况
        if (oldNode == null) {
            oldNode = newNode;
            return;
        }
        // 判断原结点是原双亲结点的左/右孩子
        if (oldNode.parent.left == oldNode) {
            oldNode.parent.left = newNode;
        } else if (oldNode.parent.right == oldNode) {
            oldNode.parent.right = newNode;
        }
        // 如果新节点不为空
        if (newNode != null) {
            newNode.parent = oldNode.parent;
        }
    }

    public static TreeNode maximum(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return maximum(root.right);
    }

    public static TreeNode minimum(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return minimum(root.left);
    }

    /**
     * 给定二叉搜索树的任意一个结点，找到他的前驱
     *
     * @param node
     * @return
     */
    public static TreeNode predecessor(TreeNode node) {
        if (node.left != null) {
            return maximum(node.left);
        }
        TreeNode parent = node.parent;
        while (parent != null && parent.right != node) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    /**
     * 给定二叉搜索树的任意一个结点，找到他的后继
     *
     * @param node
     * @return
     */
    public static TreeNode successor(TreeNode node) {
        if (node.right != null) {
            return minimum(node.right);
        }
        TreeNode parent = node.parent;
        while (parent != null && parent.left != node) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

}

