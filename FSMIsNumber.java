import java.util.HashMap;
import java.util.Map;

/**
 * @className: FSMIsNumber
 * @description: 剑指 Offer 20. 表示数值的字符串
 * @author: carl
 * @date: 2021/8/20 17:26
 */

//有限状态自动机
public class FSMIsNumber {
    public boolean isNumber(String s) {
        //对应每个状态
        Map[] states = {
                /**
                 * 用于判断当前字符，并转到对应的状态（即正确顺序的对应状态）
                 * ' ' 代表空格
                 * 's' 代表正负号
                 * 'd' 代表数字
                 * '.' 代表小数点
                 * 'e' 代表e / E
                */
                new HashMap() {
                    {
                        put(' ', 0); put('s', 1); put('d', 2); put('.', 4);
                    }
                },
                new HashMap() {
                    {
                        put('d', 2); put('.', 4);
                    }
                },
                new HashMap() {
                    {
                        put('d', 2); put('.', 3); put('e', 5); put(' ', 8);
                    }
                },
                new HashMap() {
                    {
                        put('d', 3); put('e', 5); put(' ', 8);
                    }
                },
                new HashMap() {
                    {
                        put('d', 3);
                    }
                },
                new HashMap() {
                    {
                        put('s', 6); put('d', 7);
                    }
                },
                new HashMap() {
                    {
                        put('d', 7);
                    }
                },
                new HashMap() {
                    {
                        put('d', 7); put(' ', 8);
                    }
                },
                new HashMap() {
                    {
                        put(' ', 8);
                    }
                },
        };

        //初始状态为0
        int state = 0;
        char tmp;
        for (char c : s.toCharArray()) {
            //判断字符
            if (c >= '0' && c <= '9') {
                tmp = 'd';
            } else if (c == '+' || c == '-') {
                tmp = 's';
            } else if (c == 'e' || c == 'E') {
                tmp = 'e';
            } else if (c == '.' || c == ' ') {
                tmp = c;
            } else {
                //非法字符
                tmp = '?';
            }
            //如果不存在该字符，说明非法，直接返回false
            if (!states[state].containsKey(tmp)) {
                return false;
            }
            //更新到下一状态
            state = (int) states[state].get(tmp);
        }
        //只有索引是2、3、7、8的状态才是合法的，满足其一即可
        return state == 2 || state == 3 || state == 7 || state == 8;
    }
}
