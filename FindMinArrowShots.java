import java.util.Arrays;

/**
 * @className: FindMinArrowShots
 * @description: TODO
 * @author: carl
 * @date: 2021/8/30 0:00
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //根据出发位先排序
        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);
        int res = 1;
        int pre = points[0][1]; //当前射箭处索引
        for (int i = 1; i < points.length; i++) {
            //如果下一个气球的出发点，大于当前箭矢所在位置
            if (points[i][0] > pre) {
                res++;
                pre = points[i][1];
            }
        }
        return res;
    }
}
