import java.util.Arrays;

/**
 * @className: FindContentChildren
 * @description: TODO
 * @author: carl
 * @date: 2021/8/29 23:49
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int numOfChildren = g.length, numOfCookies = s.length;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && s[j] < g[i]) {
                j++;
            }
            if (j < numOfCookies) {
                result++;
            }
        }
        return result;
    }
}
