/**
 * @className: KnuthMorrisPratt
 * @description: KMP算法
 * @author: Carl Tong
 * @date: 2022/3/5 20:03
 */
public class KnuthMorrisPratt {
    public boolean KnuthMorrisPratt(String parent, String sub) {
        int parentIndex = 0, subIndex = -1;
        // next 数组相当于 “前缀后缀最大长度值” 整体向右移动一位，然后初始值赋为 -1
        int[] next = new int[parent.length() + 1];
        next[0] = -1;
        while (parentIndex < parent.length() && subIndex < sub.length()) {
            // 如果是回到了初始位置，或者是出现相同字符了（能够形成前缀后缀串）
            if (subIndex == -1 || sub.charAt(subIndex) == parent.charAt(parentIndex)) {
                // 这里是因为，next数组是代表不包含当前字符之前的字符串中，有最长长度的相同前缀后缀，所以要先向后移动
                parentIndex++; subIndex++;
                // 不能出现没有意义的重复，即p[j] = p[ next[j ]]，所以当出现重复时需要继续递归，k = next[k] = next[next[k]] = ...
                if (parentIndex < parent.length() && subIndex < sub.length() && sub.charAt(subIndex) == parent.charAt(parentIndex)) {
                    next[parentIndex] = next[subIndex];
                // 不是的话就正常计算子串索引根据next数组跳回到哪
                } else {
                    next[parentIndex] = subIndex;
                }
            // 否则，匹配失败，移动到不包含该字符之前的模式串中有最大长度为 k 的相同前缀后缀
            } else {
                // 这里会一直找，直到找到匹配该字符，或者是回到初始位置
                subIndex = next[subIndex];
            }
        }
        // 如果子索引处等于子串长度，说明遍历完毕存在字串
        return subIndex == sub.length();
        /*// 如果子索引处等于子串长度，说明遍历完毕存在字串，返回起始位置
        if (subIndex == sub.length()) {
            return parentIndex - subIndex;
        // 否则不存在返回-1
        } else {
            return -1;
        }*/
    }
}


