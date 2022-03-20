import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @className: WordBreak
 * @description: 139. 单词拆分
 * @author: carl
 * @date: 2021/10/17 17:44
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak(s, list));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() <= 0) {
            return true;
        }
        int length = s.length();
        boolean dp[] = new boolean[length+1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (String word : wordDict) {
                int n = word.length();
                if (i < n) {
                    continue;
                }
                if (dp[i-n] && s.substring(i-n,i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
