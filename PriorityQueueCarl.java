/**
 * @className: PriorityQueue
 * @description: 优先队列(最大堆)
 * @author: Carl Tong
 * @date: 2022/4/27 16:01
 */
public class PriorityQueueCarl<Key extends Comparable<Key>> {
    // 存储数据元素
    private Key[] data;
    // 元素个数
    private int n;

    public PriorityQueueCarl(int capacity) {
        // 索引 0 不用，所以多分配一个空间
        data = (Key[]) new Comparable[capacity + 1];
    }

    public Key max() {
        return data[1];
    }

    public void insert(Key value) {
        // 扩容，新增数据
        n++; data[n] = value;
        // 然后上浮到合适位置
        floatData(n);
    }

    public void delMax() {
        // 将堆顶和堆底交换
        swap(1, n);
        // 置空数据
        data[n] = null; n--;
        // 然后将当前堆顶下沉到合适位置
        sinkData(1);
    }

    private void floatData(int index) {
        // 如果不是在堆顶，且双亲比子节点小
        while (index > 1 && data[parent(index)].compareTo(data[index]) < 0) {
            // 上浮
            swap(parent(index), index);
            // 更新索引
            index = parent(index);
        }
    }

    private void sinkData(int index) {
        // 如果已经是在堆底了（说明没有子节点）
        while (leftChild(index) <= n) {
            int largest = index, leftChild = leftChild(index), rightChild = rightChild(index);
            // 判断左右结点大小
            if (leftChild <= n && data[leftChild].compareTo(data[index]) > 0) largest = leftChild;
            if (rightChild <= n && data[rightChild].compareTo(data[index]) > 0) largest = rightChild;
            // 如果最大的是当前元素，则终止；否则交换下沉
            if (largest == index) break;
            // 交换
            swap(largest, index);
            // 下沉
            index = largest;
        }
    }

    private void swap(int x, int y) {
        Key tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }

    private int parent(int x) {
        return x / 2;
    }

    private int leftChild(int x) {
        return 2 * x;
    }

    private int rightChild(int x) {
        return 2 * x + 1;
    }

}
