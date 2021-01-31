import java.util.*;

public class 字母移位词分组 {
    /**
     * map转换为双层list
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if (resultMap.containsKey(key)) {
                resultMap.get(key).add(str);
            }
            else {
                List<String> a = new ArrayList<>();
                a.add(str);
                resultMap.put(key,a);
            }
        }
        System.out.println(resultMap.values());
        return new ArrayList<List<String>>(resultMap.values());
    }

    public static void main(String[] args) {
        Map<String,List<String>> resultMap = new HashMap<>();
        String[] text = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(text);
    }
}
