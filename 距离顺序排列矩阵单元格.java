import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 距离顺序排列矩阵单元格 {
    int R;
    int C;
    int length;
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R*C][2];
        int maxSize = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> barrel = new ArrayList<>(maxSize+1);
        for (int i = 0; i < maxSize; i++) {
            barrel.add(new ArrayList<>());
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int tempLength = countLength(R, C, r0, c0);
                barrel.get(tempLength).add(new int[]{i,j});
            }
        }
        for (int i = 0; i < R+C; i++) {
            List<int[]> item = barrel.get(i);
            for (int[] ints : item) {

            }
        }
        return null;
    }

    private static int countLength(int R, int C, int r0, int c0){
        return Math.abs(R - r0)+ Math.abs(C - c0);
    }

    public static void main(String[] args) {
        allCellsDistOrder(3,4,1,3);
    }
}
