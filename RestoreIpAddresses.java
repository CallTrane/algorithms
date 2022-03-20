import java.util.ArrayList;
import java.util.List;

/**
 * @className: RestoreIpAddresses
 * @description: 93. 复原 IP 地址
 * @author: Carl Tong
 * @date: 2022/2/11 18:23
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() >= 4 && s.length() <= 12) {
            backtrack(ans, s, 0, 1, new ArrayList());
        }
        return ans;
    }

    /**
     * 回溯法
     *
     * @param ans     结果
     * @param s       字符串
     * @param cur     当前字符串索引位置
     * @param section 准备计算第几段
     * @param path    回溯路径
     */
    public void backtrack(List<String> ans, String s, int cur, int section, List<String> path) {
        // 递归终止条件，IP地址段大于4段
        if (section > 4) {
            ans.add(String.join(".", path));
            return;
        }
        for (int i = cur; i < s.length(); i++) {
            // 如果当前截取的字符串长度大于3了，后面的都不需要继续找
            if (i - cur > 3) {
                break;
            }
            // 如果后面的长度和，大于最大长度，则进行下一轮继续截取
            if ((s.length() - 1 - i) > 3 * (4 - section)) {
                continue;
            }
            // 判断是不是有效ip地址
            if (!isValidIp(s.substring(cur, i + 1))) {
                continue;
            }
            path.add(s.substring(cur, i + 1));
            backtrack(ans, s, i + 1, section + 1, path);
            path.remove(path.size() - 1);
        }
    }

    private Boolean isValidIp(String s) {
        // 首位不能为0
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        // 截取的长度不能
        if (s.length() > 3) {
            return false;
        }
        // 不能超过255
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}