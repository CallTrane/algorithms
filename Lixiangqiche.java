import java.util.*;

/**
 * @className: Lixiangqiche
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/18 22:10
 */
public class Lixiangqiche {
    static class TestOne {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(), m = sc.nextInt();
            List<LinkedList<Integer>> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int from = sc.nextInt(), to = sc.nextInt();
                boolean hasNext = false;
                for (LinkedList<Integer> cur : res) {
                    if (cur.peekLast().equals(from)) {
                        cur.addLast(to);
                        hasNext = true;
                    }
                }
                if (!hasNext) res.add(new LinkedList<Integer>(){
                    {
                        add(from);
                        add(to);
                    }
                });
            }
            System.out.println(res.size());
        }
    }

    public int Fibonacci (int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

}
