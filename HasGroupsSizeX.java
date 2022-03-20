/**
 * @className: HasGroupsSizeX
 * @description: 914. 卡牌分组
 * @author: carl
 * @date: 2021/9/11 11:27
 */
public class HasGroupsSizeX {

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        //10000 是根据题目给出的数值范围定的
        int[] count = new int[10000];
        //求公倍数（先获取任意一个数的个数）
        int x = count[deck[0]];
        for (int num : deck) {
            count[num]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                return false;
            }
            if (count[i] > 1) {
                x = cmp(x, count[i]);
                //一旦出现任意两个数量的最小公倍数为1，则直接返回false（因为要大于等于2组）
                if (x == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    //两个数的最小公倍数
    private int cmp(int a, int b) {
        if (b == 0) {
            return a;
        }
        return cmp(b, a % b);
    }
}
