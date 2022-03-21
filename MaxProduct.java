/**
 * @className: MaxProduct
 * @description: 剑指 Offer II 005. 单词长度的最大乘积
 * @author: Carl Tong
 * @date: 2022/3/21 1:51
 */
public class MaxProduct {
    public int maxProduct(String[] words) {
        // 用二进制来存储每个字符串的字符，用 && 判断是否存在重复
        int[] wordCode = new int[words.length];
        // 先将每个字符串的字符保存
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordCode[i] |= (1 << (c - 'a'));
            }
        }
        // 计算答案 （0 & 0 = 0, 0 & 1 = 0, 1 & 0 = 0, 1 & 1 = 1）
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((wordCode[i] & wordCode[j]) == 0) res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }
}
