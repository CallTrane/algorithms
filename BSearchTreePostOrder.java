import org.junit.Test;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class BSearchTreePostOrder {

    public boolean verifyPostOrder(int numbers[]) {
        return recur(numbers, 0, numbers.length - 1);
    }

    private boolean recur(int[] numbers, int start, int end) {
        if (numbers != null && start - end >= 0) {
            return true;
        }
        int root = numbers[end];
        //在二叉搜索树中，左子树节点小于根节点
        int i = start;
        while (numbers[i] < root) {
            ++i;
        }
        //在二叉搜索树中，右子树节点大于根节点
        int j = i; //从左子树结束开始
        while (j < end) {
            if (numbers[j] < root) {
                return false;
            }
            j++;
        }
        //判断左、右子树是不是二叉搜索树
        boolean left = true;
        if (i > 0) {
            left = recur(numbers, start, i-1);
        }
        boolean right = true;
        if (i < numbers.length - 1) {
            right = recur(numbers, i, j-1);
        }

        return (left && right);
    }

    @Test
    public void test() {
        //int[] numbers1 = new int[]{5,7,6,9,11,10,8};
        int[] numbers1 = new int[]{1,3,2,6,5};
        int[] numbers2 = new int[]{4, 6, 7, 5};
        System.out.println(verifyPostOrder(numbers1));
        System.out.println(verifyPostOrder(numbers2));
    }

}
