import java.util.HashSet;
import java.util.Set;

public class 公平的糖果棒交换 {
    // 第一版O(n^2) 直接暴力解
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

    // 第二版O(n+m) 使用哈希表 快速查找。 在查找某个值的时候可以使用哈希表来减少嵌套循环
    public int[] fairCandySwapHashtable(int[] A, int[] B) {
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
        // 使用下面这种方式竟然比上面的那种遍历两次的花费的时间长 应该是少了一个n的遍历 多了2*n的判断
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

    // 第三版O(n+m) 使用数组来保留值 已知n的大小的时候可用 速度提高 通用性降低 需要处理很多数组越界相关的问题
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0, bSum = 0, diff;
        boolean[] aSet = new boolean[100001];

        for (int i : A) {
            aSum += i;
            aSet[i] = true;
        }
        for (int i : B) {
            bSum += i;
        }

        diff = (bSum - aSum) / 2;
        int need;
        for (int i : B) {
            need = i - diff;
            if (need >= 0 && need < 100001 && aSet[need]) {
                return new int[]{i - diff, i};
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
