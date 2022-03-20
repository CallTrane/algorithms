import org.junit.Test;

/**
 * @className: SubString
 * @description: TODO
 * @author: carl
 * @date: 2021/8/25 22:11
 */
public class SubString {

    public boolean isSubString(String father, String sub) {
        for (int i = 0; i < father.length(); i++) {
            for (int j = i; j < father.length(); j++) {
                if (sub.equals(father.substring(i, j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
