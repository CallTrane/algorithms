/**
 * @className: IsOneBitCharacter
 * @description: 717. 1比特与2比特字符
 * @author: Carl Tong
 * @date: 2022/2/20 13:40
 */
public class IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        int idx = 0;
        while (idx < bits.length - 1) {
            if (bits[idx] == 1) idx++;
            idx++;
        }
        // 如果遍历到最后一个字符，说明倒数第二个字符不是1，最后一个必须为0
        return idx == bits.length - 1;
    }
}

class Test {
    public static void main(String[] args) {
         new IsOneBitCharacter().isOneBitCharacter(new int[]{1,1,1,0});
    }
}
