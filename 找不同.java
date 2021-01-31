import java.util.Arrays;

public class 找不同 {
//    public char findTheDifference(String s, String t) {
//        char[] sChars = s.toCharArray();
//        char[] tChars = t.toCharArray();
//        Arrays.sort(sChars);
//        Arrays.sort(tChars);
//        for (int i = 0; i < sChars.length; i++) {
//            if (sChars[i] != tChars[i]) {
//                return tChars[i];
//            }
//        }
//        return tChars[sChars.length];
//    }

//    public char findTheDifference(String s, String t) {
//        char ans = 0;
//        for (int i = 0; i < s.length(); i++) {
//            ans ^= s.charAt(i);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            ans ^= t.charAt(i);
//        }
//        return ans;
//    }

//    public char findTheDifference(String s, String t) {
//        char ansS = 0;
//        char ansT = 0;
//        for (int i = 0; i < s.length(); i++) {
//            ansS += s.charAt(i);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            ansT += t.charAt(i);
//        }
//        return (char) (ansT - ansS);
//    }
    public char findTheDifference(String s, String t) {
        int length = s.length();
        char c = t.charAt(length);
        for (int i = 0; i < length; i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

    public static void main(String[] args) {

        char[] as = {'a','b','c','e'};
        char[] bs = {'a','b','c','e','f'};
        char a  = bs[as.length];
        for (int i = 0; i < as.length; i++) {
            a ^= as[i];
            a ^= bs[i];
        }
        System.out.println(a);
    }

}
