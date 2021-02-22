import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数组序号转换 {
    public int[] arrayRankTransform(int[] arr) {
        int[] arrI = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrI);
        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for (int i : arrI) {
            if (map.get(i) == null) {
                index++;
                map.put(i, index);
            }
        }

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}
