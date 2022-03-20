import java.util.Stack;

/**
 * @className: MinStack
 * @description: 剑指 Offer 30. 包含min函数的栈
 * @author: carl
 * @date: 2021/9/12 1:05
 */
public class MinStack {

    Stack<Integer> nums;
    Stack<Integer> min;

    public MinStack() {
        nums = new Stack();
        min = new Stack();
    }

    public void push(int x) {
        nums.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        int x = nums.pop();
        if (min.peek().equals(x)) {
            min.pop();
        }
    }

    public int top() {
        return nums.peek();
    }

    public int min() {
        return min.peek();
    }

}
