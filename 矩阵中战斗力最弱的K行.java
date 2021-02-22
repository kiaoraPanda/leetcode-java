import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 矩阵中战斗力最弱的K行 {
    private static class Pair {
        int soldier;
        int row;

        Pair(int soldier, int row) {
            this.soldier = soldier;
            this.row = row;
        }

        private int getSoldier() {
            return soldier;
        }

        private int getRow() {
            return row;
        }
    }

    // 有两个排序要求的话 按照两个排序要求排序两次即可
    public static int[] kWeakestRows(int[][] mat, int k) {
        List<Pair> power = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int soldier = Arrays.stream(mat[i]).sum();
            Pair pair = new Pair(soldier, i);
            power.add(pair);
        }
        List<Pair> ansTemp = power.stream().sorted(Comparator.comparing(Pair::getSoldier)
                                                             .thenComparing(Pair::getRow)).collect(
                Collectors.toList());

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = ansTemp.get(i).getRow();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = {
                { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1 }
        };
        kWeakestRows(a, 4);
    }
}
