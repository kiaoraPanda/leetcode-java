public class 寻找数组的中心索引 {
    // O(n^2)
//    public int pivotIndex(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int left = 0;
//            for (int j = 0; j < i; j++) {
//                left += nums[j];
//            }
//            int right = 0;
//            for (int j = i+1; j < nums.length; j++) {
//                right += nums[j];
//            }
//            if (left == right) {
//                return i;
//            }
//        }
//        return -1;
//    }
    //
    public int pivotIndex(int[] nums) {
        // 使用流会引入额外的消耗但看起来更酷 更有可读性
//      int sum = Arrays.stream(nums).sum();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            // 依次遍历就能依次知道左边的和
            if (i != 0) {
                left += nums[i - 1];
            }
            // 知道左边的和就能知道右边的和
            if ((sum - left - nums[i]) == left) {
                return i;
            }
        }
        return -1;
    }
}
