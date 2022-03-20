import java.util.HashMap;
import java.util.Map;

/**
 * @className: SequoiaDB
 * @description: 巨杉数据库
 * @author: Carl Tong
 * @date: 2022/3/18 15:00
 */
public class SequoiaDB {
    static class QuestionOne {
        public static void main(String[] args) {
            String a = new String("ab");
            String b = new String("ab");
            String aa = "ab";
            String bb = "ab";
            System.out.println(a==b);
            System.out.println(aa==bb);
            System.out.println(a.equals(b));
            System.out.println(aa.equals(bb));

        }
    }

    static class QuestionTwo {
        public static int getValue(int i) {
            int result = 0;
            switch (i) {
                case 1:
                    result = result + i;
                case 2:
                    result = result + i * 2;
                case 3:
                    result = result + i * 3;
            }
            return result;
        }

        public static void main(String[] args) {
            System.out.println(getValue(2));
        }

    }

}

// Question Three
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
class Human {
    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new Sneeze();
            } catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        } finally {
            System.out.println("Hello World!");
        }
    }
}

// Question Four
class MyKey {
    private int key;
    public MyKey(int key) {
        this.key = key;
    }
}
class MapTest1 {
    public static void main(String[] args) {
        Map<MyKey, Integer> myMap = new HashMap();
        myMap.put(new MyKey(1), 1);
        myMap.put(new MyKey(2), 2);

        Integer value = myMap.get(new MyKey(1));
        System.out.println("value=" + value);
    }
}

