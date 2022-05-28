package 字符串;

import java.util.Stack;

/**
 * @className: RemoveOuterParentheses
 * @description: 1021. 删除最外层的括号
 * @author: Carl Tong
 * @date: 2022/5/28 0:49
 */
public class RemoveOuterParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder ret = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 编排了顺序, 保证每个 '原语' 最外层的括号没了
            if (c == ')')
                stack.pop();
            if (!stack.isEmpty())
                ret.append(c);
            if (c == '(')
                stack.push(c);
        }
        return ret.toString();
    }
}
