/**
 * @className: FindCenter
 * @description: 1791. 找出星型图的中心节点
 * @author: Carl Tong
 * @date: 2022/2/18 13:59
 */
public class FindCenter {
    public int findCenter(int[][] edges) {
        int center = edges[0][0];
        for (int i = 1; i < edges.length; i++) {
            if (center != edges[i][0] && center != edges[i][1]) {
                center = edges[i - 1][1];
            }
        }
        return center;
    }
}
