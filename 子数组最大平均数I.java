public class 子数组最大平均数I {
    // 需要整数相除得转类型
    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length - k;
        int[] tempK = new int[k];
        for (int i = 0; i < k; i++) {
            tempK[i] = nums[i];
        }
        int tempSum = 0;
        for (int i : tempK) {
            tempSum += i;
        }
        double tempAverage = (double) tempSum / k;
//        double tempAverage = Arrays.stream(tempK).average().getAsDouble();
        double result = tempAverage;

        for (int i = 0; i < n; i++) {
            tempAverage += (double) nums[i + k] / k - (double) nums[i] / k;
            if (tempAverage > result) {
                result = tempAverage;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 12, -5, -6, 50, 3};
        int b = 4;

        findMaxAverage(a, b);
    }
}


