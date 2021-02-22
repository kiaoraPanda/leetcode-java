public class 回文数 {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int r = x;
        int rev = 0;
        while (r != 0) {
            int pop = r % 10;
            r /= 10;
            rev = rev * 10 + pop;
        }
        return rev == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
