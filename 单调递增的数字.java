import java.util.Arrays;

public class 单调递增的数字 {
    public static int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < chars.length && chars[i-1] <= chars[i]){
            i++;
        }
        if (i < chars.length) {
            while (i > 0 && chars[i - 1] > chars[i]) {
                chars[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < chars.length ; i++) {
                chars[i] = '9';
            }
        }

        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {


        System.out.println( monotoneIncreasingDigits(332));
    }


}
