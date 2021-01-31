public class 分发糖果 {
    //    public int candy(int[] ratings) {
//        if (ratings == null || ratings.length == 0) {
//            return 0;
//        }
//        if (ratings.length == 1) {
//            return 1;
//        }
//        int[] left = new int[ratings.length];
//        int[] right = new int[ratings.length];
//        for (int i = 1; i < ratings.length; i++) {
//            if (ratings[i - 1] < ratings[i]) {
//                left[i] = left[i - 1] + 1;
//            }
//        }
//        for (int i = ratings.length - 2; i >= 0; i--) {
//            if (ratings[i] > ratings[i + 1]) {
//                right[i] = right[i + 1] + 1;
//            }
//        }
//        int result = ratings.length;
//        for (int i = 0; i < ratings.length; i++) {
//            result += Math.max(left[i], right[i]);
//        }
//        return result;
//    }
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        if (ratings.length == 1)
            return 1;

        int[] intS = new int[ratings.length];
        // 从左往右迭代 两两元素对比 如果右边的分值大 就把右边的元素设置为左边元素+1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i])
                intS[i] = intS[i - 1] + 1;
        }
        // 从右往左迭代 两两元素对比 如果左边的分值大 而且左边的糖果少 就把左边的元素值设置为右元素+1
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                if (intS[i] <= intS[i + 1])
                    intS[i] = intS[i + 1] + 1;
        }
        // 每个人最少一个糖果，再把多分的糖果加起来
        int result = ratings.length;
        for (int i = 0; i < ratings.length; i++)
            result += intS[i];

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 0, 2};
        System.out.println(candy(a));
    }
}
