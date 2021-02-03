import java.util.Arrays;

public class 滑动窗口中位数 {
    // 数组访问次数接近
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int[] window = new int[k];
        // 根据需要滑动的次数遍历
        if (k == 1) { // 如果窗口长度为1直接遍历返回就好
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i];
            }
            return res;
        } else {
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
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2147483647, 2147483647};
        medianSlidingWindow(a, 2);
    }
}
