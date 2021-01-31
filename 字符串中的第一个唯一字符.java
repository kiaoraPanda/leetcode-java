import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class 字符串中的第一个唯一字符 {
    //第一版 效率极低 62ms
//    public static int firstUniqChar(String s) {
//        if (s == null || s.equals("")) {
//            return -1;
//        }
//        Map<Character, Integer> map = new LinkedHashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
//            } else {
//                map.put(s.charAt(i), 1);
//            }
//        }
//        Optional<Map.Entry<Character, Integer>> view = map.entrySet().stream().filter(t -> t.getValue() == 1).findFirst();
//        return view.map(t -> s.indexOf(t.getKey())).orElse(-1);
//    }
    // 22ms
//    public static int firstUniqChar(String s) {
//        if (s == null || s.equals("")) {
//            return -1;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (!map.containsKey(s.charAt(i)) && s.substring(i + 1).indexOf(s.charAt(i)) == -1) {
//                return i;
//            } else {
//                map.put(s.charAt(i), 0);
//            }
//        }
//        return -1;
//    }
    // 8ms 使用了数组计数 也就是把数组当成map使用
    public static int firstUniqChar(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++ ;
        }
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int a = firstUniqChar("cc");
        System.out.println(a);
    }
}
