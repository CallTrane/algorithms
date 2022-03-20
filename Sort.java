import org.junit.Test;

/**
 * 四种排序算法
 */
public class Sort {

    @Test
    public void testInsertSort() {
        int[] array = new int[]{5,1,3,13,4};
        for (int i : insertSort(array)) {
            System.out.print(i+" ");
        }
    }

    @Test
    public void testSelectSort() {
        int[] array = new int[]{5,1,3,13,4};
        for (int i : selectSort(array)) {
            System.out.print(i+" ");
        }
    }

    @Test
    public void testFlowSort() {
        int[] array = new int[]{5,1,3,13,4};
        for (int i : flowSort(array)) {
            System.out.print(i+" ");
        }
    }

    @Test
    public void testQickSort() {
        int[] array = new int[]{5,1,3,13,4,6,2,2};
        for (int i : quickSort(array, 0, array.length-1)) {
            System.out.print(i+" ");
        }
    }

    /**
     *  1、插入排序 时间复杂度（平均）O（n²）
     *            时间复杂度（最坏）O（n²）
     *            时间复杂度（最好）O（n）
     *            空间复杂度 O（1）
     *            稳定
     */
    /*public int[] insertSort(int array[]) {

        int i,j;
        //遍历数组的每个元素，定位一个元素，将元素与前面的比较（默认前面的已经排序好了）
        for (i = 1; i < array.length; i++) {
            //记录当前值
            int temp = array[i];
            //遍历前面的值，与temp比较，每一个比temp小（大）的就要进行交换
            for (j = i-1; j >= 0; --j) {
                //数组中每一个比该元素大的值，都应该往后移动
                if (array[j] > temp) {
                    array[j+1] = array[j];
                //当小于等于某个元素，直接跳出循环
                } else {
                    break;
                }
            }
            //终止循环后，当前下标j是多减去一次的，需要+1把temp移动到该位置
            array[j+1] = temp;
        }
        return array;
    }*/

    public int[] insertSort(int array[]) {
        int i,j;
        for (i = 1; i < array.length; i++) {
            int temp = array[i];
            for (j = i-1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = temp;
        }
        return array;
    }

    /**
     *  2、选择排序 时间复杂度（平均）O（n²）
     *            时间复杂度（最坏）O（n²）
     *            时间复杂度（最好）O（n²）
     *            空间复杂度 O（1）
     *            不稳定
     * 默认当前数是当前数组的最小数值的下标，前面的数字是有序的
     */
    /*public int[] selectSort(int array[]) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            int index = i;
            //把最小元素的下表赋给index
            for (int j = i+1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            //每遍历完一次，确认是否需要交换
            if (i != index) {
                temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        return array;
    }*/

    public int[] selectSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        return array;
    }

    /**
     *  3、冒泡排序 时间复杂度（平均）O（n²）
     *            时间复杂度（最坏）O（n²）
     *            时间复杂度（最好）O（n）
     *            空间复杂度 O（1）
     *            稳定
     */
    /*public int[] flowSort(int array[]) {
        int temp;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length-1; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }*/
    public int[] flowSort(int array[]) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    /**
     *  4、快速排序 时间复杂度（平均）O（nlog₂n)
     *            时间复杂度（最坏）O（n²）
     *            时间复杂度（最好）O（nlog₂n)
     *            空间复杂度 O（nlog₂n)
     *            不稳定
     */
    /*public int[] quickSort(int array[], int start, int end) {
        if (array == null || start > end) {
            return null;
        }
        if (start < end) {
            //确定基准数据的索引
            int index = getIndex(array, start, end);
            //递归，对每个数据都进行确定（）
            quickSort(array, start, index-1);
            quickSort(array, index+1, end);
        }
        return array;
    }

    private int getIndex(int[] array, int low, int high) {
        //保存基准数据及其索引，为了最后交换数据
        int index = low;
        int temp = array[low];
        //循环，直到 low等于high确定基准数据的索引
        while (low < high) {
            // high所指的元素，一直找直到比基准位小的
            while (low < high && array[high] >= temp) {
                high--;
            }
            //同理，low指的元素，一直找直到比基准位大的
            while (low < high && array[low] <= temp) {
                low++;
            }
            //将low和high两个位置的元素交换
            if (low < high) {
                int change = array[low];
                array[low] = array[high];
                array[high] = change;
            }
        }
        *//**
         * 当low==high的时候，将基准位和该位置替换
         *      这时候该位置的左侧元素都比该位置的元素小。右侧元素比该位置的元素大
         *//*
        array[index] = array[low];
        array[low] = temp;
        return low;
    }*/

    public int[] quickSort(int array[], int start, int end) {
        if (array == null || start > end) {
            return null;
        }
        int index = getIndex(array, start, end);
        quickSort(array, start, index-1);
        quickSort(array, index+1, end);
        return array;
    }

    private int getIndex(int[] array, int low, int high) {
        int index = low;
        int temp = array[low];
        while (low < high) {
            while (low < high && array[high] >= temp) {
                high--;
            }
            while (low < high && array[low] <= temp) {
                low++;
            }
            if (low < high) {
                int change = array[low];
                array[low] = array[high];
                array[high] = change;
            }
        }
        array[index] = array[low];
        array[low] = temp;
        return low;
    }

    /**
     * 5、堆排序（最大堆、最小堆）
     */
    public void heapSort(int[] nums) {
        int heapSize = nums.length;
        for (int i = heapSize/2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
            //minHeapify(nums, i, heapSize);
        }
    }

    //最大堆
    void maxHeapify(int[] nums, int index, int heapSize) {
        int largest = index, left = index*2 + 1, right = index*2 + 2;
        if (left < heapSize && nums[largest] < nums[left]) {
            largest = left;
        }
        if (right < heapSize && nums[largest] < nums[right]) {
            largest = right;
        }
        if (index != largest) {
            swap(nums, largest, index);
            maxHeapify(nums, largest, heapSize);
        }
    }

    //最小堆
    void minHeapify(int[] nums, int index, int heapSize) {
        int smallest = index, left = index*2 + 1, right = index*2 + 2;
        if (left < heapSize && nums[smallest] > nums[left]) {
            smallest = left;
        }
        if (right < heapSize && nums[smallest] > nums[right]) {
            smallest = right;
        }
        if (index != smallest) {
            swap(nums, smallest, index);
            maxHeapify(nums, smallest, heapSize);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
