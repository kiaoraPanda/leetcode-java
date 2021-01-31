import java.util.Arrays;

public class 分发饼干 {
    //    public static int findContentChildren(int[] g, int[] s) {
//        Arrays.sort(g);
//        Arrays.sort(s);
//        int length = Math.min(g.length, s.length);
//        int res = 0;
//        for (int i = 0, j = 0; i < g.length && j < s.length; i++, j++) {
//            while (j < s.length) {
//                if (g[i] <= s[j]) {
//                    res++;
//                    break;
//                } else {
//                    j++;
//                }
//            }
//        }
//        return res;
//    }
    public static int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, i = 0, j = 0;
        while (!(i < g.length || j < s.length)) {
            while (j < s.length) {
                if (g[i] <= s[j]) {
                    res++;
                    i++;
                    j++;
                    break;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3}, b = {3};
        findContentChildren(a, b);
    }
}
