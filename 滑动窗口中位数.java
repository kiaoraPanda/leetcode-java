import java.util.*;

public class 滑动窗口中位数 {
    // 第一版 暴力解法
    public static double[] medianSlidingWindowViolence(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int[] window = new int[k];
        // 根据需要滑动的次数遍历
        if (k == 1) { // 如果窗口长度为1直接遍历返回就好
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i];
            }
            return res;
        }
        for (int i = 0; i < res.length; i++) {
            // 为窗口赋值
            for (int j = 0; j < k; j++) {
                window[j] = nums[j + i];
            }
            Arrays.sort(window);
            // 求中位数
            double left, right;
            if (k % 2 == 1) {
                res[i] = window[(window.length - 1) / 2];
            } else {
                right = (double) window[window.length / 2];
                left = (double) window[window.length / 2 - 1];
                res[i] = (right + left) / 2;
            }
        }
        return res;
    }

    // 第二版 暴力解法 优化窗口的赋值方式
    public static double[] medianSlidingWindowViolence2(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int[] window = new int[k];
        boolean isOdd = k % 2 == 1;
        // 根据需要滑动的次数遍历
        if (k == 1) { // 如果窗口长度为1直接遍历返回就好
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i];
            }
            return res;
        }

        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        // 窗口有序副本
        int[] sortedWind = new int[k];
        System.arraycopy(nums, 0, sortedWind, 0, k);
        Arrays.sort(sortedWind);

        for (int i = k; i < nums.length; i++) {
            double left, right;
            if (isOdd) {
                res[i] = window[(window.length - 1) / 2];
            } else {
                right = (double) window[window.length / 2];
                left = (double) window[window.length / 2 - 1];
                res[k - i] = (right + left) / 2;
            }
            Arrays.sort(window);
            // 求中位数
        }
        return res;
    }

    // 第三版 双优先队列 + 延迟删除 时间复杂度为O(nlogn) 通过设计数据结构来降低复杂度，而且使用数据结构可以很好的提升主程序的可读性
    // TODO 此为官方题解 目前并没有看懂
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; ++i) {
            dh.insert(nums[i]);
        }
        double[] ans = new double[nums.length - k + 1];
        ans[0] = dh.getMedian();
        for (int i = k; i < nums.length; ++i) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            ans[i - k + 1] = dh.getMedian();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2147483647, 2147483647};
        medianSlidingWindowViolence(a, 2);
    }
}

class DualHeap {
    // 大根堆，维护较小的一半元素
    private PriorityQueue<Integer> small;
    // 小根堆，维护较大的一半元素
    private PriorityQueue<Integer> large;
    // 哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数
    private Map<Integer, Integer> delayed;

    private int k;
    // small 和 large 当前包含的元素个数，需要扣除被「延迟删除」的元素
    private int smallSize, largeSize;

    public DualHeap(int k) {
        this.small = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2.compareTo(num1);
            }
        });
        this.large = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num1.compareTo(num2);
            }
        });
        this.delayed = new HashMap<Integer, Integer>();
        this.k = k;
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public double getMedian() {
        return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
    }

    public void insert(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            ++smallSize;
        } else {
            large.offer(num);
            ++largeSize;
        }
        makeBalance();
    }

    public void erase(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if (num <= small.peek()) {
            --smallSize;
            if (num == small.peek()) {
                prune(small);
            }
        } else {
            --largeSize;
            if (num == large.peek()) {
                prune(large);
            }
        }
        makeBalance();
    }

    // 不断地弹出 heap 的堆顶元素，并且更新哈希表
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }

    // 调整 small 和 large 中的元素个数，使得二者的元素个数满足要求
    private void makeBalance() {
        if (smallSize > largeSize + 1) {
            // small 比 large 元素多 2 个
            large.offer(small.poll());
            --smallSize;
            ++largeSize;
            // small 堆顶元素被移除，需要进行 prune
            prune(small);
        } else if (smallSize < largeSize) {
            // large 比 small 元素多 1 个
            small.offer(large.poll());
            ++smallSize;
            --largeSize;
            // large 堆顶元素被移除，需要进行 prune
            prune(large);
        }
    }
}
