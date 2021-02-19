import java.util.HashMap;
import java.util.Map;

public class 找出数组中的幸运数 {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getKey() == integerIntegerEntry.getValue()) {
                res = Math.max(res, integerIntegerEntry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 5, 73, 5, 2, 52, 2, 2, 2, 2, 2 };


    }


}
