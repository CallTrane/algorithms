import org.junit.Test;

/**
 * 05题目：请实现一个函数，把字符串中的每个空格替换成“%20”。
 */
public class ReplaceBlank {

    public String replace(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        int index = 0;
        char[] array = new char[str.length() * 3];
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = c;
            }
        }
        String newStr = new String(array, 0, index);
        return newStr;
    }

    @Test
    public void test() {
        String s = "We are Happy.";
        String replace = replace(s);
        System.out.println(replace);
    }
}
