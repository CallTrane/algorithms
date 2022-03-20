import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @className: PermutationString
 * @description: 剑指 Offer 38. 字符串的排列
 * @author: carl
 * @date: 2021/8/13 1:59
 */
public class PermutationString {

    //保存结果
    List<String> res = new ArrayList();

    //操作每个字符串的字符数组
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        //将字符串数组ArrayList转换为String类型数组，返回指定个数
        return res.toArray(new String[res.size()]);
    }

    void dfs(int depth) {
        //此时已经是最后一层了，添加字符串后返回上一层
        if (depth == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        //创建一个辅助Set，用来判断是否已经存在重复元素
        HashSet<Character> set = new HashSet();
        //从当前深度开始
        for (int i = depth; i < c.length; i++) {
            //如果当前已经存在重复元素，则剪枝后直接进入下一次循环
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            //交换下一个元素，创建新的排列
            swap(i,depth);
            //接着进入下一层
            dfs(depth+1);
            //每次出来之后，要把字符数组恢复原状，否则辅助Set会判断错误丢失排列
            swap(i,depth);
        }
    }

    void swap(int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";
        PermutationString test = new PermutationString();
        String[] permutation = test.permutation(s);
        System.out.print("[");
        for (int i = 0; i < permutation.length; i++) {
            String str = permutation[i];
            System.out.print("\"" + str + "\"");
            if ((i+1) != permutation.length) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

}
