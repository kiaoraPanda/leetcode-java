import java.util.HashSet;
import java.util.Set;

public class 公平的糖果棒交换 {
    // 第一版 直接暴力解 时间复杂度为O(n^2)
    public int[] fairCandySwapViolence(int[] A, int[] B) {
        int aSum = 0, bSum = 0, diff;
        for (int i : A) {
            aSum += i;
        }
        for (int i : B) {
            bSum += i;
        }
        diff = (bSum - aSum) / 2;

        for (int k : A) {
            for (int i : B) {
                if (i - k == diff) {
                    return new int[]{k, i};
                }
            }
        }

        return null;
    }

    // 第二版 使用哈希表 快速查找。 在查找某个值的时候可以使用哈希表来减少嵌套循环
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0, bSum = 0, diff;
        Set<Integer> set = new HashSet<>();

        // 计算A与B中所有值得和 以及把A中的数存进map中以备查找
        for (int i : A) {
            aSum += i;
            set.add(i);
        }
        for (int i : B) {
            bSum += i;
        }
        // 使用下面这种方式竟然比上面的那种遍历两次的花费的时间长
//        for (int i = 0; i < Math.max(A.length, B.length); i++) {
//            if (i < A.length) {
//                aSum += A[i];
//                set.add(A[i]);
//            }
//            if (i < B.length) {
//                bSum += B[i];
//            }
//        }

        // x = y - (bSum - aSum) / 2
        diff = (bSum - aSum) / 2;
        for (int k : B) {
            if (set.contains(k - diff)) {
                return new int[]{k - diff, k};
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
