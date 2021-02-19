import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两个数组的交集2 {
    /**
     * 用Hash表方法 时间复杂度为O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {      // 用简单的“递归”来实现参数大小的控制 这样的实现简单优雅啊
            intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            int a = map.getOrDefault(i, 0) + 1;
            map.put(i, a);
        }
        int[] resTemp = new int[nums1.length];
        int index = 0;
        for (int i : nums2) {
            int count = map.getOrDefault(i, 0);
            if (count > 0) {
                resTemp[index++] = i;
                count--;
                if ((count > 0)) {
                    map.put(i, count);
                }
                else {
                    map.remove(i);
                }
            }
        }
        return Arrays.copyOf(resTemp, index);
    }

    /**
     * 双指针法 时间复杂度为O(mlogm+nlogn)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect2(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length = nums1.length;
        int a = 0;
        int b = 0;
        int index = 0;
        int[] tempRes = new int[length];
        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] == nums2[b]) {
                tempRes[index++] = nums1[a];
                a++;
                b++;
            }
            else if (nums1[a] < nums2[b]) {
                a++;
            }
            else {
                b++;
            }
        }
        return Arrays.copyOfRange(tempRes, 0, index);
    }

    public static void main(String[] args) {
        int[] a = new int[] { 4, 9, 5 };
        int[] b = { 9, 4, 9, 8, 4 };
        int[] c = intersect2(a, b);
        Arrays.stream(c).forEach(System.out::println);
    }
}
