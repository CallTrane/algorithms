import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @className: ReorderLogFiles
 * @description: 937. 重新排列日志文件
 * @author: Carl Tong
 * @date: 2022/5/3 16:13
 */
public class ReorderLogFiles {

    class Log {
        int type, index;
        String sign, content, origin;

        public Log(String origin, int index) {
            this.origin = origin;
            this.index = index;
            int i = 0;
            // 确认符号
            while (i < origin.length() && origin.charAt(i) != ' ') i++;
            sign = origin.substring(0, i);
            // 确认内容（排除掉当前的空格，所以要i + 1
            content = origin.substring(i + 1);
            // 确认是字母还是数字，数字要排在后面，所以大点
            type = Character.isDigit(content.charAt(0)) ? 1 : 0;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        List<Log> list = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) list.add(new Log(logs[i], i));
        Collections.sort(list, (a, b) -> {
            // 如果是数字与字母，则数字拍后面
            if (a.type != b.type) return a.type - b.type;
            // 否则，如果都是数字的话。则按题目保留原来顺序
            if (a.type == 1) return a.index - b.index;
            // 否则即都是字母的情况。在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
            return !a.content.equals(b.content) ? a.content.compareTo(b.content) : a.sign.compareTo(b.sign);
        });
        String[] res = new String[logs.length];
        for (int i = 0; i < logs.length; i++) {
            res[i] = list.get(i).origin;
        }
        return res;
    }

}
