import java.util.Stack;

/**
 * @className: StackPushPop
 * @description: 剑指 Offer 31. 栈的压入、弹出序列
 * @author: carl
 * @date: 2021/8/16 12:35
 */
public class StackPushPop {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int now = 0;
        for (int num : pushed) {
            stack.push(num);
            //连续出栈需要用while判断
            while (!stack.isEmpty() && stack.peek() == popped[now]) {
                stack.pop();
                ++now;
            }
        }
        return stack.isEmpty();
    }
}
