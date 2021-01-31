import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//划分字母区间
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println("aa");
        var partitionLabels = new PartitionLabels();
        var S = "sdfdf";
        var result = partitionLabels.partitionLabels(S);
        result.forEach(System.out::println);
    }

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public List<Integer> partitionLabels2(String S){
        var result = new ArrayList<Integer>();
        int start = 0 , end = 0;
        var map = new HashMap<Character,Integer>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, map.get(S.charAt(i)));
            if(end == i){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }


}
